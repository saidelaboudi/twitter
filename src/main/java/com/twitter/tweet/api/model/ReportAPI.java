package com.twitter.tweet.api.model;

import com.twitter.tweet.domain.model.ReportDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportAPI {
    public ReportDomain toDomain() {
        return null;
    }
}
