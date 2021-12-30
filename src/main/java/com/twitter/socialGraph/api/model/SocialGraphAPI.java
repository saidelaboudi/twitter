package com.twitter.socialGraph.api.model;

import com.twitter.socialGraph.domain.model.SocialGraphDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialGraphAPI {
    private Long id;
    private UserAPI owner;
    private List<UserAPI> blocked;
    private List<UserAPI> followed;
    private List<UserAPI> reported;

    public SocialGraphDomain toDomain() {
        return new SocialGraphDomain(
                this.id,
                this.owner.toDomain(),
                this.blocked==null?null:this.blocked.stream().map(UserAPI::toDomain).collect(Collectors.toList()),
                this.followed==null?null:this.followed.stream().map(UserAPI::toDomain).collect(Collectors.toList()),
                this.reported==null?null:this.reported.stream().map(UserAPI::toDomain).collect(Collectors.toList())
        );
    }
}
