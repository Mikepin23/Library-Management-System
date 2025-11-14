package com.jac.alexandria.Alexandria.Library.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {
    @EmbeddedId
    private AuthorityId id;

    public Authority() {}
    public Authority(AuthorityId id) { this.id = id; }
    public AuthorityId getId() { return id; }
    public void setId(AuthorityId id) { this.id = id; }
    public String getUsername() { return id != null ? id.getUsername() : null; }
    public String getAuthority() { return id != null ? id.getAuthority() : null; }
}
