package zzyzzy.hello.boot.spring5boot.service;

import org.springframework.web.multipart.MultipartFile;
import zzyzzy.hello.boot.spring5boot.model.Gallery;

import java.util.List;

public interface GalleryService {
    List<Gallery> readGallery(Integer cpg);

    int countGallery();

    int newGallery(Gallery g);

    boolean newGalAttach(List<MultipartFile> attachs, int gno);
}
