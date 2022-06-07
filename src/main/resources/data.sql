-- 상위 카테고리
INSERT INTO CateMain(Id, Name) VALUES (1, '디자인');
INSERT INTO CateMain(Id, Name) VALUES (2, '외국어');
INSERT INTO CateMain(Id, Name) VALUES (3, '뮤직');
INSERT INTO CateMain(Id, Name) VALUES (4, '스포츠');

-- 하위 카테고리
INSERT INTO CateSub(Category, Name, DisplayOrder) VALUES (1, '브랜드 디자인', 1);
INSERT INTO CateSub(Category, Name, DisplayOrder) VALUES (1, '제품 디자인', 2);

INSERT INTO CateSub(Category, Name, DisplayOrder) VALUES (2, '영어', 1);
INSERT INTO CateSub(Category, Name, DisplayOrder) VALUES (2, '중국어', 2);
INSERT INTO CateSub(Category, Name, DisplayOrder) VALUES (2, '일본어', 3);

INSERT INTO CateSub(Category, Name, DisplayOrder) VALUES (3, '보컬', 1);
INSERT INTO CateSub(Category, Name, DisplayOrder) VALUES (3, '악기', 2);

INSERT INTO CateSub(Category, Name, DisplayOrder) VALUES (4, '골프', 1);
INSERT INTO CateSub(Category, Name, DisplayOrder) VALUES (4, '격투기', 2);
INSERT INTO CateSub(Category, Name, DisplayOrder) VALUES (4, '수상 스포츠', 3);
INSERT INTO CateSub(Category, Name, DisplayOrder) VALUES (4, '생활 스포츠', 4);

-- 사용자
INSERT INTO Accounts(Id, name, ContactEmail) Values (1, 'Timo', 'timo@taling.me');