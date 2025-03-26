package com.cydeo.service.serviceImpl;

// The reason Map should be containing DTO object here is
// to use hashMap structure as a mock DB, and we should design this hashMap
// contain not DTO instead Entity object E.g. Map<Long,User> not Map<Long,UserDTO>
// but we just did that because of the convenience.

import com.cydeo.customeException.NoUniqueKeyException;
import com.cydeo.dto.UserDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractMapMockDB<Id,T>{
    protected Map<Id,T> dbMap=new HashMap<>();

    public T save(Id id,T object){
        dbMap.put(id,object);
        return object;
    }
    public List<T> findAll(){
      List<T> list= new ArrayList<>(dbMap.values());
      if(list.stream(). allMatch(each->each instanceof UserDTO) ){
          list=list.stream().filter(userDTO-> ((UserDTO) userDTO).isEnabled())
                  .collect(Collectors.toList());
      }
      return list;
    }

    public T findById(Id id){
        return dbMap.get(id);
    }

    public void deleteById(Id id){
       dbMap.remove(id);
    }

    public void softDeleteById(Id id){
        T object=this.findById(id);
        if(object instanceof UserDTO){
            ((UserDTO) object).setEnabled(false);
        }

        // update dbMap after set enable = false
//        this.update(id,object);
    }

    public void update(Id id,T object){
        if(!dbMap.containsKey(id))
            throw new NoUniqueKeyException("There is no userName as uniqueKey");
        dbMap.computeIfPresent(id,(k,v)->v=object);
    }

}
