-- ++++++++++++++++++++++
--         課題01
-- ++++++++++++++++++++++
-- データベースの作成
CREATE DATABASE sb_inventorydb
CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;

-- テーブルの作成
USE sb_inventorydb;

CREATE TABLE items (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
purchased_at DATE NOT NULL,
note VARCHAR(255)
);

CREATE TABLE rooms (
id CHAR(4) PRIMARY KEY,
name VARCHAR(30) NOT NULL
);

CREATE TABLE placements (
item_id INT,
room_id CHAR(4),
amount INT NOT NULL,
PRIMARY KEY(item_id, room_id)
);

-- 初期データの投入
INSERT INTO items VALUES
(1, 'デスクトップPC(DP-100S)', '2021-07-14', '120GBのSSD。メモリは16GB'),
(2,'PC用モニター(MN-2000K)', '2021-07-14', NULL),
(3,'ノートPC(FT-2100R)', '2021-08-10', 'オフィス系ソフトがインストール済み'),
(4,'プリンター(KTR-2500S)', '2021-08-12', '複合機。リース'),
(5,'A4コピー用紙(500枚)', '2021-08-16', NULL),
(6,'A3コピー用紙(500枚)', '2021-08-16', NULL),
(7,'B4コピー用紙(500枚)', '2021-08-16', NULL);

INSERT INTO rooms VALUES
('R101', '倉庫'),
('R201', '総務部'),
('R211', '開発部'),
('R301', '会議室');

INSERT INTO placements VALUES
(1, 'R101', 1),
(1, 'R211', 6),
(1, 'R301', 1),
(2, 'R101', 2),
(2, 'R211', 12),
(2, 'R301', 2),
(3, 'R101', 1),
(3, 'R201', 3),
(4, 'R201', 1),
(5, 'R101', 20),
(6, 'R101', 10),
(7, 'R101', 5);

-- 備品リストページ用
SELECT p.item_id, i.name, SUM(p.amount), i.purchased_at, i.note
FROM placements AS p
JOIN items AS i
ON i.id = p.item_id
GROUP BY p.item_id
ORDER BY i.name;

-- 備品の個別表示ページ用 （備品番号1番の場合）
SELECT * FROM items WHERE id = 1;

SELECT r.name, p.amount
FROM placements AS p
JOIN rooms AS r
ON p.room_id = r.id
WHERE p.item_id = 1
ORDER BY r.id;


-- ++++++++++++++++++++++
--         課題04
-- ++++++++++++++++++++++
-- テーブルの作成
USE sb_inventorydb;

CREATE TABLE admins (
login_id VARCHAR(10) PRIMARY KEY,
login_pass CHAR(60) NOT NULL,
name VARCHAR(30) NOT NULL
);
