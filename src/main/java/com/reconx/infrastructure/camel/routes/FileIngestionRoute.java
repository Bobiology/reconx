package com.reconx.infrastructure.camel.routes;

import com.reconx.infrastructure.camel.processor.CsvFileProcessor;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FileIngestionRoute
        extends RouteBuilder {

    private final CsvFileProcessor csvProcessor;

    @Value("${file.uploads.path}")
    String uploadPath;
    @Override
    public void configure() {

        from("file:"+uploadPath+"?noop=true")
                .routeId("csv-file-ingestion")

                .log("Processing file ${file:name}")

                .choice()

                .when(header("CamelFileName")
                        .endsWith(".csv"))

                .convertBodyTo(String.class)
                .process(csvProcessor)

                .log(
                        "CSV file processed successfully"
                )

                .otherwise()

                .log("Unsupported file type");

    }
}
