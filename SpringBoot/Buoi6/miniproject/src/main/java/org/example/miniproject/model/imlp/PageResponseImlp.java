package org.example.miniproject.model.imlp;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.example.miniproject.model.IPageResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@Builder

public class PageResponseImlp<T> implements IPageResponse {

  int currentPage;
  int pageSize;
  List<T> content;

  @Override
  public int getCurrentPage() {
    return currentPage;
  }

  @Override
  public int getPageSize() {
    return pageSize;
  }

  @Override
  public int getTotalElements() {
    return content.size();
  }

  @Override
  public int getTotalPages() {
    return (int) Math.ceil((double) getTotalElements() / getPageSize());
  }

  @Override
  public List<T> getContent() {
    int fromIndex = (currentPage - 1) * pageSize;
    if (fromIndex >= content.size()) {
      return List.of();
    }
    int toIndex = Math.min(fromIndex + pageSize, content.size());
    return content.subList(fromIndex, toIndex);
  }
}
