
package mn.service.github.commits;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "sha",
    "node_id",
    "html_url",
    "comments_url",
    "commit",
    "shortAuthor",
    "shortCommitter",
    "parents",
    "repository",
    "score"
})
public class UserCommits {

    @JsonProperty("url")
    public String url;
    @JsonProperty("sha")
    public String sha;
    @JsonProperty("node_id")
    public String nodeId;
    @JsonProperty("html_url")
    public String htmlUrl;
    @JsonProperty("comments_url")
    public String commentsUrl;
    @JsonProperty("commit")
    public Commit commit;
    @JsonProperty("author")
    public LongAuthor author;
    @JsonProperty("committer")
    public LongCommitter committer;
    @JsonProperty("parents")
    public List<Parent> parents = null;
    @JsonProperty("repository")
    public Repository repository;
    @JsonProperty("score")
    public Integer score;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
