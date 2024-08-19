package org.example.miniproject.model;

import java.util.List;

public interface IPageResponse<T> {

  int getCurrentPage();

  int getPageSize();

  int getTotalElements();

  int getTotalPages();

  List<T> getContent();
}
