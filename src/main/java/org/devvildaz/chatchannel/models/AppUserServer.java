package org.devvildaz.chatchannel.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class AppUserServer {
    @EmbeddedId
    private MemberId id;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private AppUser user;

    @MapsId("serverId")
    @ManyToOne
    @JoinColumn(name="server_id", nullable = false)
    private AppServer server;

    @OneToMany(mappedBy = "members")
    private Set<AppRole> roles;

}


@Embeddable
class MemberId implements Serializable {
    @Column(name = "user_id")
    public UUID userId;
    @Column(name = "server_id")
    public UUID serverId;
}
