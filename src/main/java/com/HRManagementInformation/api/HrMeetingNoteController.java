package com.HRManagementInformation.api;

import com.HRManagementInformation.business.abstracts.IHrMeetingNoteService;
import com.HRManagementInformation.core.config.modelMapper.IModelMapperService;
import com.HRManagementInformation.core.result.Result;
import com.HRManagementInformation.core.result.ResultData;
import com.HRManagementInformation.core.utilies.ResultHelper;
import com.HRManagementInformation.dto.request.hrMeetingNote.HrMeetingNoteSaveRequest;
import com.HRManagementInformation.dto.request.hrMeetingNote.HrMeetingNoteUpdateRequest;
import com.HRManagementInformation.dto.response.HrMeetingNoteResponse;
import com.HRManagementInformation.entities.HrMeetingNote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/hrmeetingnote")
public class HrMeetingNoteController {
    @Autowired
    private final IHrMeetingNoteService hrMeetingNoteService;
    @Autowired
    private final IModelMapperService modelMapperService;

    public HrMeetingNoteController(IHrMeetingNoteService hrMeetingNoteService, IModelMapperService modelMapperService) {
        this.hrMeetingNoteService = hrMeetingNoteService;
        this.modelMapperService = modelMapperService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<List<HrMeetingNoteResponse>> getAllHrMeetingNote(){
        List<HrMeetingNote> hrMeetingNotes = this.hrMeetingNoteService.getAll();
        List<HrMeetingNoteResponse> hrMeetingNoteResponses = hrMeetingNotes.stream()
                .map(note -> this.modelMapperService.forResponse().map(note, HrMeetingNoteResponse.class))
                .collect(Collectors.toList());

        return ResultHelper.success(hrMeetingNoteResponses);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<HrMeetingNoteResponse> getHrMeetingNoteById(@PathVariable("id") int id){
        HrMeetingNote hrMeetingNote = this.hrMeetingNoteService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(hrMeetingNote, HrMeetingNoteResponse.class));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<HrMeetingNoteResponse> createHrMeetingNote
            (@RequestBody HrMeetingNoteSaveRequest hrMeetingNoteSaveRequest){
        this.hrMeetingNoteService.save(this.modelMapperService.forRequest().map(hrMeetingNoteSaveRequest, HrMeetingNote.class));
        return ResultHelper.created(this.modelMapperService.forResponse().map(hrMeetingNoteSaveRequest, HrMeetingNoteResponse.class));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<HrMeetingNoteResponse> updateHrMeetingNote
            (@PathVariable("id") int id,
             @RequestBody HrMeetingNoteUpdateRequest hrMeetingNoteUpdateRequest) {

        HrMeetingNote hrMeetingNote = this.hrMeetingNoteService.get(id);
        this.modelMapperService.forRequest().map(hrMeetingNoteUpdateRequest, hrMeetingNote);
        this.hrMeetingNoteService.update(hrMeetingNote);

        return ResultHelper.updated(this.modelMapperService.forResponse().map(hrMeetingNote, HrMeetingNoteResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteHrMeetingNote(@PathVariable("id") int id){
        this.hrMeetingNoteService.delete(id);
        return ResultHelper.deleted();
    }

}



