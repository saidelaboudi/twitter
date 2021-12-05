package com.twitter.homeTimeLine.domain.model;

import com.twitter.homeTimeLine.api.model.KeyWordsAPI;
import com.twitter.homeTimeLine.infra.model.KEY_WORDS;
import com.twitter.homeTimeLine.infra.model.KeyWord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyWordDomain {
    private Long id;
    private KEY_WORDS key_word;

    public KeyWordsAPI toApi(){
        return new KeyWordsAPI();
    }

    public KeyWord toInfra(){
        return new KeyWord();
    }


}
