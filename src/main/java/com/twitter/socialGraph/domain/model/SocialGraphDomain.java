package com.twitter.socialGraph.domain.model;

import com.twitter.socialGraph.api.model.SocialGraphAPI;
import com.twitter.socialGraph.infra.model.SocialGraph;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialGraphDomain {
    private Long id;
    private UserDomain owner;
    private List<UserDomain> blocked;
    private List<UserDomain> followed;
    private List<UserDomain> reported;

    public void report(UserDomain reportedUserDomain) {
        reported.add(reportedUserDomain);
    }

    public SocialGraph toInfra() {
        return new SocialGraph(
                this.id,
                owner.toInfra(),
                this.blocked == null ? null : this.blocked.stream().map(UserDomain::toInfra).collect(Collectors.toList()),
                this.followed == null ? null : this.followed.stream().map(UserDomain::toInfra).collect(Collectors.toList()),
                this.reported == null ? null : this.reported.stream().map(UserDomain::toInfra).collect(Collectors.toList())
        );
    }

    public SocialGraphAPI toAPI() {
        return new SocialGraphAPI(
                this.id,
                owner.toAPI(),
                this.blocked == null ? null : this.blocked.stream().map(UserDomain::toAPI).collect(Collectors.toList()),
                this.followed == null ? null : this.followed.stream().map(UserDomain::toAPI).collect(Collectors.toList()),
                this.reported == null ? null : this.reported.stream().map(UserDomain::toAPI).collect(Collectors.toList())
        );
    }
}
