package com.lecture.studyolle.settings;

import com.lecture.studyolle.domain.Account;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class Profile {
    @Length(max = 35)
    private String bio;

    @Length(max = 50)
    private String url;

    @Length(max = 35)
    private String occupation;

    @Length(max = 35)
    private String location;

    private String profileImage;

    public Profile(Account account){
        this.bio = account.getBio();
        this.url = account.getUrl();
        this.occupation = account.getOccupation();
        this.profileImage = account.getProfileImage();
    }
}
