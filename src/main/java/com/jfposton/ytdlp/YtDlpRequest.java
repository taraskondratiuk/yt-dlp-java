package com.jfposton.ytdlp;

import java.util.*;
import java.util.Map.Entry;

/** YtDlp request */
public class YtDlpRequest {

  /** Executable working directory */
  private String directory;

  /** Video Url */
  private String url;

  /** List of executable options */
  private Map<String, String> options = new HashMap<>();

  public String getDirectory() {
    return directory;
  }

  public void setDirectory(String directory) {
    this.directory = directory;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Map<String, String> getOption() {
    return options;
  }

  public void setOption(String key) {
    options.put(key, null);
  }

  public void setOption(String key, String value) {
    options.put(key, value);
  }

  public void setOption(String key, int value) {
    options.put(key, String.valueOf(value));
  }

  /** Constructor */
  public YtDlpRequest() {}

  /**
   * Construct a request with a videoUrl
   *
   * @param url
   */
  public YtDlpRequest(String url) {
    this.url = url;
  }

  /**
   * Construct a request with a videoUrl and working directory
   *
   * @param url
   * @param directory
   */
  public YtDlpRequest(String url, String directory) {
    this.url = url;
    this.directory = directory;
  }

  /**
   * Transform options to a string that the executable will execute
   *
   * @return Command string
   */
  protected ArrayList<String> buildOptions() {

    ArrayList<String> builder = new ArrayList<>();

    // Set Url
    if (url != null) builder.add(url);

    // Build options strings
    Iterator<Entry<String, String>> it = options.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<String, String> option = it.next();

      String name = option.getKey();
      String value = option.getValue();

      builder.add("--" + name);
      if (value != null) {
        builder.add(value);
      }

      it.remove();
    }

    return builder;
  }
}
