package me.tinydonuts.data;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.util.HashMap;

public class SaveFile {

    // private final ObjectMapper mapper;
    // private final TypeFactory factory;
    // private final MapType type;

    private final String fileName;

    public SaveFile(String fileName) {
        this.fileName = fileName;

        // mapper = new ObjectMapper();
        // TypeFactory typeFactory = mapper.getTypeFactory();
        // mapType = typeFactory.constructMapType(MAP_CLASS.class, KEY.class, VALUE.class);
    }

    public String getFileName() {
        return fileName;
    }

    /*
    public void writeToFile() throws IOException {
        mapper.writer(new DefaultPrettyPrinter()).writeValue(SAVE_FILE, MAP);
        // mapper.writer().writeValue(path.toFile(), map);
    }

    public HashMap<KEY.class, VALUE.class> readFromFile() throws IOException {
        return MAP = mapper.readValue(SAVE_FILE, type);
    }
    */
}
