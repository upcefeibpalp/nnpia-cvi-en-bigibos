package cz.upce.fei.nnpiacv.repository;

import cz.upce.fei.nnpiacv.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {
}
