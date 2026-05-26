package com.reconx.upload.parser;

import org.apache.commons.csv.*;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class CsvParserService {

    public List<Map<String, String>> parse(InputStream inputStream) {

        try {

            Reader reader = new InputStreamReader(inputStream);

            CSVParser csvParser = CSVFormat.DEFAULT
                    .withFirstRecordAsHeader()
                    .parse(reader);

            List<Map<String, String>> records = new ArrayList<>();

            for (CSVRecord record : csvParser) {

                Map<String, String> row = new HashMap<>();

                csvParser.getHeaderMap().forEach((key, value) ->
                        row.put(key, record.get(key)));

                records.add(row);
            }

            return records;

        } catch (IOException ex) {
            throw new RuntimeException("CSV parsing failed", ex);
        }
    }
}
