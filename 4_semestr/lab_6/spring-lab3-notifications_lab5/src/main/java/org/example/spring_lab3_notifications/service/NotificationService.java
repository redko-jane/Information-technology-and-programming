package org.example.spring_lab3_notifications.service;

import lombok.RequiredArgsConstructor;
import org.example.spring_lab3_notifications.model.dto.NotificationDto;
import org.example.spring_lab3_notifications.model.entity.Notification;
import org.example.spring_lab3_notifications.model.entity.User;
import org.example.spring_lab3_notifications.model.enums.NotificationChannel;
import org.example.spring_lab3_notifications.model.enums.NotificationStatus;
import org.example.spring_lab3_notifications.repository.NotificationRepository;
import org.example.spring_lab3_notifications.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    @Transactional
    public Notification createNotification(NotificationDto request) {
        User user = userRepository.findById(request.getRecipientId())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден с id: " + request.getRecipientId()));

        Notification notification = new Notification();
        notification.setTitle(request.getTitle());
        notification.setMessage(request.getMessage());
        notification.setChannel(request.getChannel());
        notification.setStatus(NotificationStatus.CREATED);
        notification.setCreatedAt(LocalDateTime.now());
        notification.setRecipient(user);

        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Уведомление не найдено"));
    }

    @Transactional
    public Notification updateNotification(Long id, NotificationDto request) {
        Notification notification = getNotificationById(id);
        notification.setTitle(request.getTitle());
        notification.setMessage(request.getMessage());
        notification.setChannel(request.getChannel());

        if (request.getStatus() != null) {
            notification.setStatus(request.getStatus());
            if (request.getStatus() == NotificationStatus.SENT) {
                notification.setSentAt(LocalDateTime.now());
            }
        }

        return notificationRepository.save(notification);
    }

    @Transactional
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

    public List<Notification> getByStatus(NotificationStatus status) {
        return notificationRepository.findByStatus(status);
    }

    public List<Notification> getByStatusSortedAsc(NotificationStatus status) {
        return notificationRepository.findByStatusOrderByCreatedAtAsc(status);
    }

    public List<Notification> getByStatusSortedDesc(NotificationStatus status) {
        return notificationRepository.findByStatusOrderByCreatedAtDesc(status);
    }

    public List<Notification> getByChannel(NotificationChannel channel) {
        return notificationRepository.findByChannel(channel);
    }

    public List<Notification> getByStatusAndChannel(NotificationStatus status, NotificationChannel channel) {
        return notificationRepository.findByStatusAndChannel(status, channel);
    }

    public List<Notification> getByRecipientId(Long recipientId) {
        return notificationRepository.findByRecipientId(recipientId);
    }

    public List<Notification> getByStatusAndChannelCustom(NotificationStatus status, NotificationChannel channel) {
        return notificationRepository.findByStatusAndChannelCustom(status, channel);
    }

    public List<Notification> getNativeByStatusAndChannel(String status, String channel) {
        return notificationRepository.findNativeByStatusAndChannel(status, channel);
    }

    public List<Notification> getByRecipientIdAndStatus(Long recipientId, NotificationStatus status) {
        return notificationRepository.findByRecipientIdAndStatus(recipientId, status);
    }
}
