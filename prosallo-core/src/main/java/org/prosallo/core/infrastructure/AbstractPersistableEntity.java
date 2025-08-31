package org.prosallo.core.infrastructure;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;
import lombok.Setter;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
public abstract class AbstractPersistableEntity implements Persistable<Long> {

    @Id
    @Setter
    private Long id;

    @Transient
    private boolean isNew;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }

    @PrePersist
    @PostLoad
    public void markNowNew() {
        this.isNew = false;
    }
}
