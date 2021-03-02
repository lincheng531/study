package com.lincheng.study.alioss;

import com.alibaba.fastjson.JSON;
import com.lincheng.study.alioss.Enum.FileTypeEnum;
import com.lincheng.study.alioss.entity.OssFileInformation;
import com.lincheng.study.alioss.repository.OssFileInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StudyAliossApplication.class)
public class StudyAliossApplicationTests {

	@Resource
	private OssFileInformationRepository ossFileInformationRepository;

	@Test
	public void contextLoads() {
		OssFileInformation ossFileInformation = OssFileInformation.builder()
				.fileType(1)
				.fileName("测试名称")
				.ossFileName("oss名称")
				.md5Hex("sddsfasfareqwvadsf")
				.remark("备注")
				.addTime(new Date())
				.modifyTime(new Date())
				.operatorId(1L)
				.operatorName("测试名称")
				.build();

		OssFileInformation save = ossFileInformationRepository.save(ossFileInformation);
		System.out.println(JSON.toJSONString(save));
	}

	@Test
	public void test1(){
		String type = "png";

		FileTypeEnum fileTypeEnum = Arrays.stream(FileTypeEnum.values())
				.filter(alarmGrade -> alarmGrade.getName().equals(type))
				.findFirst()
				.orElse(null);
		if (fileTypeEnum!=null) {

		}


		boolean present = Arrays.stream(FileTypeEnum.values()).anyMatch(alarmGrade -> alarmGrade.getName().equals(type));


		System.out.println(present);

		if (Optional.ofNullable(Arrays.stream(FileTypeEnum.values())
				.filter(alarmGrade -> alarmGrade.getName().equals(type))
				.findFirst()
				.orElse(null)).isPresent()) {
			//不为空
			System.out.println(fileTypeEnum.getName());
			System.out.println(fileTypeEnum.getKey());
			System.out.println(true);
		}else {
			System.out.println(false);


		}



	}


}
