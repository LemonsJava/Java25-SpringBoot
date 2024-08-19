package org.example.demothymeleaf2.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@ToString
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor

public class PageResponseImlp<T> implements IPageResponse<T> {

  int currentPage;
  int pageSize;
  List<T> data;

  @Override
  public int getCurrentPage() {
    return currentPage;
  }

  @Override
  public int getPageSize() {
    return this.pageSize;
  }

  @Override
  public int getTotalElements() {
    return data.size();
  }

  @Override
  public int getTotalPages() {
    return (int) Math.ceil((double) getTotalElements() / getPageSize());
  }

  @Override
  public List<T> getContent() {
    int fromIndex = (currentPage - 1) * pageSize;
    if (fromIndex >= data.size()) {
      return List.of();
    }
    int toIndex = Math.min(fromIndex + pageSize, data.size());
    return data.subList(fromIndex, toIndex);
  }
}
