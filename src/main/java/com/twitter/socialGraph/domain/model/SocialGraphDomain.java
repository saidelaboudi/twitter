package com.twitter.socialGraph.domain.model;

import com.twitter.socialGraph.api.model.SocialGraphAPI;
import com.twitter.socialGraph.api.model.UserAPI;
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
    private List<UserDomain> blocked;
    private List<UserDomain> followed;
    private List<UserDomain> reported;

    public void report(UserDomain reportedUserDomain) {
        reported.add(reportedUserDomain);
    }

    public SocialGraph toInfra() {
        List<User> blockedInfra = new ArrayList<User>();
        List<User> followedInfra = new ArrayList<User>();
        List<User> reportedInfra = new ArrayList<User>();
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
                blockedInfra,
                followedInfra,
                reportedInfra
        );
    }

    public SocialGraphAPI toAPI() {
        List<UserAPI> blocked = new ArrayList<UserAPI>();
        List<UserAPI> followed = new ArrayList<UserAPI>();
        List<UserAPI> reported = new ArrayList<UserAPI>();
        this.blocked.forEach(user -> {
            blocked.add(user.toAPI());
        });
        this.followed.forEach(user -> {
            followed.add(user.toAPI());
        });
        this.reported.forEach(user -> {
            reported.add(user.toAPI());
        });
        return new SocialGraphAPI(
                this.id,
                blocked,
                followed,
                reported
        );
    }
}
