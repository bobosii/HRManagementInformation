package com.HRManagementInformation;

import com.HRManagementInformation.business.abstracts.ILeaveTypeService;
import com.HRManagementInformation.entities.LeaveType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HrManagementInformationApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrManagementInformationApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ILeaveTypeService leaveTypeService) {
        return args -> {
            if (leaveTypeService.getAll().isEmpty()) {
                leaveTypeService.save(new LeaveType(0, "Yıllık İzin", "Her yıl çalışanlara tanımlanan yıllık izin hakkı."));
                leaveTypeService.save(new LeaveType(0, "Hastalık İzni", "Sağlık sorunları nedeniyle alınan izin."));
                leaveTypeService.save(new LeaveType(0, "Doğum İzni", "Doğum yapan çalışanlar için özel izin."));
                leaveTypeService.save(new LeaveType(0, "Babalık İzni", "Baba olan çalışanlara özel izin."));
                leaveTypeService.save(new LeaveType(0, "Ücretsiz İzin", "Maaşsız olarak alınan izin türüdür."));
                leaveTypeService.save(new LeaveType(0, "Evlenme İzni", "Evlenen çalışanlara verilen kısa süreli izin."));
                leaveTypeService.save(new LeaveType(0, "Cenaze İzni", "Birinci derece yakının vefatında verilen izin."));
                leaveTypeService.save(new LeaveType(0, "Görevli İzin", "Kurumsal görevlendirme nedeniyle alınan izin."));
                leaveTypeService.save(new LeaveType(0, "Yarım Gün İzin", "Yarım iş günü izin alma durumu."));
                leaveTypeService.save(new LeaveType(0, "İdari İzin", "Resmi kurumlarca belirlenen idari izin günleri."));
            }
        };
    }
}
