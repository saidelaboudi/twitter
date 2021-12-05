package com.twitter.homeTimeLine.api.model;

import com.twitter.homeTimeLine.domain.model.KeyWordDomain;
import com.twitter.homeTimeLine.infra.model.KEY_WORDS;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyWordsAPI {

    private Long id;
    private KEY_WORDS key_word;

    public KeyWordDomain toDomain() {
        return new KeyWordDomain(this.id,this.key_word);
    }
}
