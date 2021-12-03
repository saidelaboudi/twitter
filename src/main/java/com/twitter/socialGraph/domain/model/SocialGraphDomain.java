package com.twitter.socialGraph.domain.model;

import com.twitter.socialGraph.infra.model.SocialGraph;
import com.twitter.socialGraph.infra.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
        List<User> blockedInfra= new ArrayList<User>();
        List<User> followedInfra= new ArrayList<User>();
        List<User> reportedInfra= new ArrayList<User>();
        this.blocked.forEach(user -> {
            blockedInfra.add(user.toInfra());
        });
        this.followed.forEach(user -> {
            followedInfra.add(user.toInfra());
        });
        this.reported.forEach(user -> {
            reportedInfra.add(user.toInfra());
        });
        return new SocialGraph(
                this.id,
                this.owner.toInfra(),
                blockedInfra,
                followedInfra,
                reportedInfra
        );
    }
}
