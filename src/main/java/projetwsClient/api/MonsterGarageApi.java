	package projetwsClient.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import projetwsClient.model.Voiture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MonsterGarageApi implements Api<Voiture> {

    private static final String url = "http://localhost:8088/";

    @Autowired
    private ApiService apiService;

    private ObjectMapper mapper;

    public MonsterGarageApi() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public Voiture[] getAll() {
    	
        return mapper.convertValue(apiService.getList(url), new TypeReference<Voiture[]>() {
        });
    }

    @Override
    public Voiture get(int id) {
        return mapper.convertValue(apiService.get(url + '/' + id), new TypeReference<Voiture>() {
        });
    }

    @Override
    public Voiture create(Voiture entity) throws JsonProcessingException {
        Object data = apiService.post(url, mapper.writeValueAsString(entity));
        return mapper.convertValue(data, new TypeReference<Voiture>() {
        });
    }

    @Override
    public Voiture edit(Voiture entity) throws JsonProcessingException {
        Object data = apiService.put(url + '/' + entity.getId(), mapper.writeValueAsString(entity));
        return mapper.convertValue(data, new TypeReference<Voiture>() {
        });
    }

    @Override
    public Voiture delete(int id) {
        return null;
    }
}