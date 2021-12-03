package com.twitter.socialGraph.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialGraphAPI {
    private Long id;
    private UserAPI owner;
    private List<UserAPI> blocked;
    private List<UserAPI> followed;
    private List<UserAPI> reported;
}
