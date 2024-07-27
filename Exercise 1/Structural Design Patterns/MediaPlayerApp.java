// Target interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee interface
interface AdvancedMediaPlayer {
    void playMP4(String fileName);
    void playVLC(String fileName);
}

// Concrete adaptee classes
class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playMP4(String fileName) {
        System.out.println("Playing MP4 file. Name: " + fileName);
    }

    @Override
    public void playVLC(String fileName) {
        // Do nothing
    }
}

class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMP4(String fileName) {
        // Do nothing
    }

    @Override
    public void playVLC(String fileName) {
        System.out.println("Playing VLC file. Name: " + fileName);
    }
}

// Adapter class
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMusicPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("MP4")) {
            advancedMusicPlayer = new MP4Player();
        } else if (audioType.equalsIgnoreCase("VLC")) {
            advancedMusicPlayer = new VLCPlayer();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("MP4")) {
            advancedMusicPlayer.playMP4(fileName);
        } else if (audioType.equalsIgnoreCase("VLC")) {
            advancedMusicPlayer.playVLC(fileName);
        }
    }
}

// Concrete class implementing the target interface
class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("MP3")) {
            System.out.println("Playing MP3 file. Name: " + fileName);
        } else if (audioType.equalsIgnoreCase("MP4") || audioType.equalsIgnoreCase("VLC")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

// Usage
public class MediaPlayerApp {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("MP3", "song.mp3");
        audioPlayer.play("MP4", "video.mp4");
        audioPlayer.play("VLC", "movie.vlc");
        audioPlayer.play("AVI", "clip.avi");
    }
}
