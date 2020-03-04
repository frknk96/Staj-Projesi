package com.ElasticStaj.prop;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
@Getter
@Setter
public class ConfigProps {

    @NestedConfigurationProperty
    private Clients clients = new Clients();

    @NestedConfigurationProperty
    private ElasticContainer elastic = new ElasticContainer();

    @NestedConfigurationProperty
    private Index index = new Index();


    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    public ElasticContainer getElastic() {
        return elastic;
    }

    public void setElastic(ElasticContainer elastic) {
        this.elastic = elastic;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }
}
