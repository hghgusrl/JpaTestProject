package com.example.jpatestproject.jpaSample.service.impl;

import com.example.jpatestproject.jpaSample.dto.GuestbookDTO;
import com.example.jpatestproject.jpaSample.dto.PageRequestDTO;
import com.example.jpatestproject.jpaSample.dto.PageResultDTO;
import com.example.jpatestproject.jpaSample.entity.Guestbook;
import com.example.jpatestproject.jpaSample.repository.GuestbookRepository;
import com.example.jpatestproject.jpaSample.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor // 의존성 자동 주입
public class GuestbookServiceImpl implements GuestbookService{

    private final GuestbookRepository repository;

    @Override
    public Long register(GuestbookDTO dto) {
        return null;
    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());

        Page<Guestbook> result = repository.findAll(pageable);

        Function<Guestbook,GuestbookDTO> fn = (entity -> entityToDto(entity));
        // JPA의 처리결과인 Page<Entity>와 Function을 전달해 엔티티 객체들을 DTO의 리스트로 변환하고 화면에 페이지 처리와 필요한 값들을 생성한다
        return new PageResultDTO<>(result,fn);
    }

    @Override
    public Guestbook dtoToEntity(GuestbookDTO dto) {
        return GuestbookService.super.dtoToEntity(dto);
    }

    @Override
    public GuestbookDTO entityToDto(Guestbook entity) {
        return GuestbookService.super.entityToDto(entity);
    }
}
