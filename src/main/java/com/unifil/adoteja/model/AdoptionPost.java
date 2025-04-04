package com.unifil.adoteja.model;

import com.unifil.adoteja.enums.AnimalType;
import com.unifil.adoteja.enums.Sex;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class AdoptionPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column
    private String name;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private AnimalType animalType;

    @Column(nullable = false, length = 6)
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(nullable = false)
    private Boolean castrated;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean active;

    private LocalDateTime adoptionDate;

    @Column(name = "image_path")
    @CollectionTable(name = "adoption_images", joinColumns = @JoinColumn(name = "post_id"))
    @ElementCollection
    private List<String> imagePath;
}
