
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
    "login",
    "id",
    "node_id",
    "avatar_url",
    "gravatar_id",
    "url",
    "html_url",
    "followers_url",
    "following_url",
    "gists_url",
    "starred_url",
    "subscriptions_url",
    "organizations_url",
    "repos_url",
    "events_url",
    "received_events_url",
    "type",
    "site_admin"
})
public class Owner {

    @JsonProperty("login")
    public String login;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("node_id")
    public String nodeId;
    @JsonProperty("avatar_url")
    public String avatarUrl;
    @JsonProperty("gravatar_id")
    public String gravatarId;
    @JsonProperty("url")
    public String url;
    @JsonProperty("html_url")
    public String htmlUrl;
    @JsonProperty("followers_url")
    public String followersUrl;
    @JsonProperty("following_url")
    public String followingUrl;
    @JsonProperty("gists_url")
    public String gistsUrl;
    @JsonProperty("starred_url")
    public String starredUrl;
    @JsonProperty("subscriptions_url")
    public String subscriptionsUrl;
    @JsonProperty("organizations_url")
    public String organizationsUrl;
    @JsonProperty("repos_url")
    public String reposUrl;
    @JsonProperty("events_url")
    public String eventsUrl;
    @JsonProperty("received_events_url")
    public String receivedEventsUrl;
    @JsonProperty("type")
    public String type;
    @JsonProperty("site_admin")
    public Boolean siteAdmin;
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
