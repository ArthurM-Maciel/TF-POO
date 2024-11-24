package dados;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PersistenciaDados {
    private static final String FILE_NAME = "dados.json";

    public static void salvarDados(List<Transporte> transportes) throws IOException {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(transportes, writer);
        }
    }

    public static List<Transporte> carregarDados() throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_NAME)) {
            Type transporteListType = new TypeToken<List<Transporte>>() {}.getType();
            return gson.fromJson(reader, transporteListType);
        }
    }
}