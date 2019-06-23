package lien.job.part;

import lien.job.api.Job;

import java.util.HashMap;

public class JobFactory {
    public static Job createBasic(String name){
        return new part_job(new HashMap<String,Object>() {{
            put("name", name);
        }});
    }
}
