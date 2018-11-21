package cs.service.core.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs.service.core.listeners.StartListeners;
import org.apache.commons.beanutils.BeanUtils;
import vn.cs123.lib.system.SystemMain;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstract base class for ticket management service resource.
 */
public abstract class AbstractResource {
    protected final SystemMain _systemMain = StartListeners.getSystem();

    protected void copyProperties(Object dest, Object source) {
        try {
            BeanUtils.copyProperties(dest, source);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected String convertMapToJson(Map<String, Object> mapObject) {
        if (null == mapObject)
            return "";
        try {
            return new ObjectMapper().writeValueAsString(mapObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    protected String outputJson(int code,Object entityDTO) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        if (null == entityDTO)
            result.put("data", new ArrayList<>());
        try {
            result.put("data", entityDTO);
            return new ObjectMapper().writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
