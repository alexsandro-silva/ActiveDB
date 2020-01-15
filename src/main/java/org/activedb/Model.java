/*
 * Copyright 2020 Alexsandro Rodrigues.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activedb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alexsandro Rodrigues
 */
public class Model {
    
    private final Map<String, Object> attributes = new HashMap<>();
    private final List<String> dirty = new ArrayList<>();
    
    public void set(String name, Object value) {
        if (name == null || value == null) {
            throw new IllegalArgumentException("Nome e valor do atributo devem ser fornecidos");
        }
        
        if (this.attributes.containsKey(name)) {
            this.dirty.add(name);
        }
        
        this.attributes.put(name, value);
    }
    
    public void set(Map<String, Object> attrs) {
        if (attrs == null || attrs.isEmpty()) {
            throw new IllegalArgumentException("Os atributos devem ser informados");
        }
        
        attrs.keySet().forEach((key) -> {
            if (this.attributes.containsKey(key)) {
                this.dirty.add(key);
            }
            
            this.attributes.put(key, attrs.get(key));
        });
    }
    
    public Object get(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Atributo não informado");
        }
        
        return this.attributes.get(name);
    }
    
    public List<String> getDirtyAttributes() {
        return this.dirty;
    }
}
