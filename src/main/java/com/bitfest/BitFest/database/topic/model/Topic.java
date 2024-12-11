package com.bitfest.BitFest.database.topic.model;

import com.bitfest.BitFest.request_model.TopicBody;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topic {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "added_on")
    private Long addedOn;

    @Column(name = "last_modified")
    private Long lastModified;

    public void update(TopicBody body){
        name = body.getName();
        description = body.getDescription();
        lastModified = System.currentTimeMillis();
    }

}
