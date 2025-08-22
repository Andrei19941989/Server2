package com.example.server2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> //репозиторий для общения с базой данных чтобьы дсотавать и ьдоавблять туда-JpaRepository уже существует  в spring(интерфейс spring)-Long-тип данных id
{

}