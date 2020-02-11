
package mn.service.github.commits;

import java.util.HashMap;
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
    "shortAuthor",
    "shortCommitter",
    "message",
    "tree",
    "comment_count"
})
public class Commit {

    @JsonProperty("url")
    public String url;
    @JsonProperty("shortAuthor")
    public ShortAuthor shortAuthor;
    @JsonProperty("shortCommitter")
    public ShortCommitter shortCommitter;
    @JsonProperty("message")
    public String message;
    @JsonProperty("tree")
    public Tree tree;
    @JsonProperty("comment_count")
    public Integer commentCount;
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
