package ru.magenta.distancecalculator.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.magenta.distancecalculator.entity.Distance;
import ru.magenta.distancecalculator.exception.CityNotFoundException;
import ru.magenta.distancecalculator.repository.CityRepository;
import ru.magenta.distancecalculator.repository.DistanceRepository;
import ru.magenta.distancecalculator.request.RequestFileXML;
import ru.magenta.distancecalculator.service.FileService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {

    private final CityRepository cityRepository;
    private final DistanceRepository distanceRepository;

    private final File file = new File("src/main/resources/uploadFiles/target.xml");

    public FileServiceImpl(CityRepository cityRepository,
                           DistanceRepository distanceRepository) {
        this.cityRepository = cityRepository;
        this.distanceRepository = distanceRepository;
    }

    @Override
    public ResponseEntity<?> saveRequestToDB(MultipartFile multipartFile) {
        saveFileInPackage(multipartFile);
        RequestFileXML requestFileXML = unmarshallingFile();

        cityRepository.saveAll(requestFileXML.getCities());
        distanceRepository.saveAll(requestFileXML.getDistances()
                .stream()
                .map(dist -> new Distance(
                        cityRepository.findCityById(dist.getFromCity())
                                .orElseThrow(() -> new CityNotFoundException("Not found City in DB!")),
                        cityRepository.findCityById(dist.getToCity())
                                .orElseThrow(() -> new CityNotFoundException("Not found City in DB!")),
                        dist.getDistance()
                ))
                .collect(Collectors.toList()));
        return ResponseEntity.ok("200");
    }

    private void saveFileInPackage(MultipartFile multipartFile) {
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(multipartFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private RequestFileXML unmarshallingFile() {
        RequestFileXML requestFileXML;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(RequestFileXML.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            requestFileXML = (RequestFileXML) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return requestFileXML;
    }
}
