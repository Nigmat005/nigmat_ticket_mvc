package com.cydeo.service.serviceImpl;

// The reason Map should be containing DTO object here is
// to use hashMap structure as a mock DB, and we should design this hashMap
// contain not DTO instead Entity object E.g. Map<Long,User> not Map<Long,UserDTO>
// but we just did that because of the convenience.

import com.cydeo.customeException.NoUniqueKeyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapMockDB<Id,T>{
    protected Map<Id,T> dbMap=new HashMap<>();

    public T save(Id id,T object){
        dbMap.put(id,object);
        return object;
    }
    public List<T> findAll(){
        return new ArrayList<>(dbMap.values());
    }

    public T findById(Id id){
        return dbMap.get(id);
    }

    public void deleteById(Id id){
         dbMap.remove(id);
    }

    public void update(Id id,T object){
        if(!dbMap.containsKey(id))
            throw new NoUniqueKeyException("There is no userName as uniqueKey");
        dbMap.computeIfPresent(id,(k,v)->v=object);
    }

}
