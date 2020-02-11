package mn.service;

import com.fasterxml.jackson.databind.JsonNode;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.QueryValue;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import mn.service.github.commits.UserCommits;
import mn.service.models.SearchResults;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Stream;

@Controller("/")
@Slf4j
public class GithubController {

    @Inject
    private GithubClient client;

    @Get("/")
    public String index() {
        return client.user();
    }

    @Get("/{url}")
    public String get(String url) {
        return client.get(url);
    }

    @Get("/search/commits")
    public SearchResults<UserCommits> searchTest(@QueryValue("q") String searchTerm) {
        SearchResults<UserCommits> value = client.searchCommits(searchTerm);
        return value;
    }

    // test endpoint
    @Get("/search/commits/raw")
    public JsonNode searchRaw(@QueryValue("q") String searchTerm) {
        JsonNode value = client.searchCommitsRaw(searchTerm);

        value.fieldNames().forEachRemaining(name -> System.out.println(name + ":" + value.get(name).getNodeType()));
        JsonNode finalValue = value.findValues("items").stream().limit(1)
                .peek(i -> log.info("{}", i.size()))
                .flatMap(node -> Stream.of(node.elements()))
                .findFirst()
                .get()
                .next();


        finalValue
                .fieldNames()
                .forEachRemaining(name -> log.info("{}:{}", name, finalValue.get(name).getNodeType()));
        return value;
    }
}
