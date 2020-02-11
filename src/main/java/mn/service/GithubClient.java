package mn.service;

import com.fasterxml.jackson.databind.JsonNode;
import io.micronaut.http.annotation.*;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.HttpStatus;
import mn.service.models.SearchResults;

@Header(name="Accept",value="application/vnd.github.v3+json")
@Header(name="Authorization",value="bearer ${api.github.token}")
@Header(name="User-Agent", value ="${api.github.username}")
@Client("https://api.github.com")
public interface GithubClient {


    @Get("/user")
    public String user();

    @Get("/{url}")
    String get(String url);

    @Get("/search/commits?q={searchTerm}")
    @Consumes("application/vnd.github.cloak-preview")
    @Header(name="Accept", value="application/vnd.github.cloak-preview")
    <T> SearchResults<T> searchCommits(String searchTerm);

    @Get("/search/commits?q={searchTerm}")
    @Consumes("application/vnd.github.cloak-preview")
    @Header(name="Accept", value="application/vnd.github.cloak-preview")
    JsonNode searchCommitsRaw(String searchTerm);

    @Get("/search/commits?q={searchTerm}")
    @Consumes("application/vnd.github.cloak-preview")
    @Header(name="Accept", value="application/vnd.github.cloak-preview")
    <T> T searchCommitsGeneric(String searchTerm);

}
