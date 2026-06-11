package org.example.spring_lab3_notifications.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.spring_lab3_notifications.model.dto.NotificationDto;
import org.example.spring_lab3_notifications.model.entity.Notification;
import org.example.spring_lab3_notifications.model.enums.NotificationChannel;
import org.example.spring_lab3_notifications.model.enums.NotificationStatus;
import org.example.spring_lab3_notifications.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/add")
    public NotificationDto createNotification(@RequestBody @Valid NotificationDto request) {
        Notification response = notificationService.createNotification(request);
        return mapToDto(response);
    }

    @GetMapping("/all")
    public List<NotificationDto> getAllNotifications() {
        return notificationService.getAllNotifications().stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/{id}")
    public NotificationDto getNotificationById(@PathVariable Long id) {
        Notification response = notificationService.getNotificationById(id);
        return mapToDto(response);
    }

    @PutMapping("/{id}")
    public NotificationDto updateNotification(@PathVariable Long id, @RequestBody @Valid NotificationDto request) {
        Notification response = notificationService.updateNotification(id, request);
        return mapToDto(response);
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return "Уведомление с id " + id + " удалено";
    }

    @GetMapping("/status/{status}")
    public List<NotificationDto> getByStatus(@PathVariable NotificationStatus status) {
        return notificationService.getByStatus(status).stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/channel/{channel}")
    public List<NotificationDto> getByChannel(@PathVariable NotificationChannel channel) {
        return notificationService.getByChannel(channel).stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/recipient/{recipientId}")
    public List<NotificationDto> getByRecipientId(@PathVariable Long recipientId) {
        return notificationService.getByRecipientId(recipientId).stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/status/{status}/channel/{channel}")
    public List<NotificationDto> getByStatusAndChannel(@PathVariable NotificationStatus status,
                                                       @PathVariable NotificationChannel channel) {
        return notificationService.getByStatusAndChannel(status, channel).stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/status/{status}/asc")
    public List<NotificationDto> getByStatusSortedAsc(@PathVariable NotificationStatus status) {
        return notificationService.getByStatusSortedAsc(status).stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/status/{status}/desc")
    public List<NotificationDto> getByStatusSortedDesc(@PathVariable NotificationStatus status) {
        return notificationService.getByStatusSortedDesc(status).stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/custom/status/{status}/channel/{channel}")
    public List<NotificationDto> getByStatusAndChannelCustom(@PathVariable NotificationStatus status,
                                                             @PathVariable NotificationChannel channel) {
        return notificationService.getByStatusAndChannelCustom(status, channel).stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/native/status/{status}/channel/{channel}")
    public List<NotificationDto> getNativeByStatusAndChannel(@PathVariable String status,
                                                             @PathVariable String channel) {
        return notificationService.getNativeByStatusAndChannel(status, channel).stream()
                .map(this::mapToDto)
                .toList();
    }

    @GetMapping("/recipient/{recipientId}/status/{status}")
    public List<NotificationDto> getByRecipientIdAndStatus(@PathVariable Long recipientId,
                                                           @PathVariable NotificationStatus status) {
        return notificationService.getByRecipientIdAndStatus(recipientId, status).stream()
                .map(this::mapToDto)
                .toList();
    }

    private NotificationDto mapToDto(Notification notification) {
        return NotificationDto.builder()
                .title(notification.getTitle())
                .message(notification.getMessage())
                .channel(notification.getChannel())
                .status(notification.getStatus())
                .createdAt(notification.getCreatedAt())
                .sentAt(notification.getSentAt())
                .recipientId(notification.getRecipient().getId())
                .build();
    }
}
