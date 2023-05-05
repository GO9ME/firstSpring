package kr.multicampus.erp.dept;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileUploadLogic {
	
	public List<DeptFileDTO> uploadFiles(List<MultipartFile> multipartFiles, String path) throws IllegalStateException, IOException{
		List<DeptFileDTO> filedtolist = new ArrayList<DeptFileDTO>();
		
		for ( MultipartFile multipartFile : multipartFiles) {
			String originalFilename = multipartFile.getOriginalFilename();
			String storeFilename = createStoreFilename(originalFilename);
			
			multipartFile.transferTo(new File(path + File.separator + storeFilename));
			filedtolist.add(new DeptFileDTO(originalFilename, storeFilename));
		}
		
		return filedtolist;
		
	}
	private String createStoreFilename(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		String ext = originalFilename.substring(pos+1);
		String uuid = UUID.randomUUID().toString();
		return uuid + "." + ext;
		
	}
}
