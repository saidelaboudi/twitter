package com.twitter.tweet.api.model;

import com.twitter.directMessage.api.model.ReactionAPI;
import com.twitter.tweet.domain.model.TweetDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TweetAPI {
    private Long id;
    private String text;
    private List<ReactionAPI> reactions = new ArrayList<ReactionAPI>();
    private List<ReplyAPI> replies = new ArrayList<ReplyAPI>();
    private List<ReportAPI> reports = new ArrayList<ReportAPI>();

    public TweetDomain toDomain() {
        return new TweetDomain(
                this.id, 
                this.text,
                this.reactions==null ? null : this.reactions.stream().map(it -> it.toDomain()).collect(Collectors.toList()), 
                this.replies==null ? null : this.replies.stream().map(it -> it.toDomain()).collect(Collectors.toList()), 
                this.reports==null ? null : this.reports.stream().map(it -> it.toDomain()).collect(Collectors.toList())
        );
    }
}
