package com.igu.developer.demo.service;

import com.igu.developer.demo.GiphyService;
import com.igu.developer.demo.dao.CustomRepository;
import com.igu.developer.demo.model.Custom;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomService {

    private final CustomRepository customRepository;
    private final GiphyService giphyService;

    public CustomService(CustomRepository customRepository, GiphyService giphyService) {
        this.customRepository = customRepository;
        this.giphyService = giphyService;
    }

    @GraphQLQuery(name = "customs")
    public List<Custom> getCustoms() {
        return customRepository.findAll();
    }

    @GraphQLQuery(name = "custom")
    public Optional<Custom> getById(@GraphQLArgument(name = "id") Long id) {
        return customRepository.findById(id);
    }

    @GraphQLMutation(name = "saveCustom")
    public Custom save(@GraphQLArgument(name = "custom") Custom custom) {
        return customRepository.save(custom);
    }

    @GraphQLMutation(name = "deletecustom")
    public void deleteCustom(@GraphQLArgument(name = "id") Long id) {
        customRepository.deleteById(id);
    }

    @GraphQLQuery(name = "isCool")
    public boolean isCool(@GraphQLContext Custom custom) {
        return !custom.getName().equals("AMC Gremlin") &&
                !custom.getName().equals("Triumph Stag") &&
                !custom.getName().equals("Ford Pinto") &&
                !custom.getName().equals("Yugo GV");
    }

    @GraphQLQuery(name = "giphyUrl")
    public String getGiphyUrl(@GraphQLContext Custom custom) {
        return giphyService.getGiphyUrl(custom.getName());
    }
}
