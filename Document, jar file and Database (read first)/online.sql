USE [OnlineQuiz]
GO
/****** Object:  Table [dbo].[Question]    Script Date: 4/18/2020 10:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[content] [nvarchar](500) NULL,
	[option1] [nvarchar](500) NULL,
	[option2] [nvarchar](500) NULL,
	[option3] [nvarchar](500) NULL,
	[option4] [nvarchar](500) NULL,
	[answer] [nvarchar](500) NULL,
	[created] [date] NULL,
 CONSTRAINT [PK__Question__3213E83F5C3138FD] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QuizHistory]    Script Date: 4/18/2020 10:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuizHistory](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[userID] [int] NULL,
	[score] [varchar](10) NULL,
	[status] [varchar](50) NULL,
 CONSTRAINT [PK_QuizHistory] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 4/18/2020 10:32:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NULL,
	[password] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[type] [bit] NULL,
 CONSTRAINT [PK__Users__3213E83FDFB2E99E] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Question] ON 

INSERT [dbo].[Question] ([id], [content], [option1], [option2], [option3], [option4], [answer], [created]) VALUES (81, N'qw', N'qw', N'qw', N'qw', N'qw', N'1', CAST(N'2020-04-12' AS Date))
INSERT [dbo].[Question] ([id], [content], [option1], [option2], [option3], [option4], [answer], [created]) VALUES (83, N'2', N'2', N'2', N'2', N'2', N'1', CAST(N'2020-04-12' AS Date))
INSERT [dbo].[Question] ([id], [content], [option1], [option2], [option3], [option4], [answer], [created]) VALUES (84, N'sd', N'sd', N'sd', N'sd', N'sd', N'1', CAST(N'2020-04-12' AS Date))
INSERT [dbo].[Question] ([id], [content], [option1], [option2], [option3], [option4], [answer], [created]) VALUES (85, N'zxc', N'zxc', N'zxc', N'zxc', N'zxc', N'1', CAST(N'2020-04-12' AS Date))
INSERT [dbo].[Question] ([id], [content], [option1], [option2], [option3], [option4], [answer], [created]) VALUES (86, N'cv', N'cv', N'cv', N'cv', N'cv', N'123', CAST(N'2020-04-12' AS Date))
SET IDENTITY_INSERT [dbo].[Question] OFF
SET IDENTITY_INSERT [dbo].[QuizHistory] ON 

INSERT [dbo].[QuizHistory] ([id], [userID], [score], [status]) VALUES (8, 1010, N'', N'rejected')
INSERT [dbo].[QuizHistory] ([id], [userID], [score], [status]) VALUES (9, 1010, N'', N'rejected')
INSERT [dbo].[QuizHistory] ([id], [userID], [score], [status]) VALUES (10, 1026, N'', N'rejected')
SET IDENTITY_INSERT [dbo].[QuizHistory] OFF
SET IDENTITY_INSERT [dbo].[Users] ON 

INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (6, N'thaoqs', N'1', N'alo@gmail.com', 1)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1006, N'quyxanh019', N'12345678', N'huyhoangbluedemon019@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1007, N'thaoqs11', N'1', N'alo@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1008, N'thaoqs111', N'1', N'alo@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1010, N'12', N'12', N'quang@gmail.com', 1)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1011, N'22', N'22', N'huyhoangbluedemon019@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1012, N'admin', N'Ã¡d', N'khjk@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1013, N'abc', N'1', N'khjk@gmail.com', 1)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1014, N'cde', N'1', N'huyhoangbluedemon019@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1015, N'quang', N'quang', N'quang', 1)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1016, N'quang1', N'quang', N'quang', 1)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1017, N'quangquang', N'quang', N'quang@gmail.com', 1)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1018, N'qu', N'qw', N'quang@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1019, N'1', N'1', N'quang@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1020, N'12345435', N'412341234', N'quang@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1021, N'123', N'123', N'quang@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1022, N'1234', N'1234', N'quang@gmail.com', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1023, N'12341234', N'12341234', N'quang@gmail.com', 1)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1024, N'1234234234', N'1234124521452', N'quang@gmail', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1025, N'1234234234trrty', N'tyrrtyywry', N'quang#$#%$@gmail', 0)
INSERT [dbo].[Users] ([id], [username], [password], [email], [type]) VALUES (1026, N'111', N'111', N'quang@gmail.com', 1)
SET IDENTITY_INSERT [dbo].[Users] OFF
ALTER TABLE [dbo].[Question] ADD  CONSTRAINT [DF__Question__create__3B75D760]  DEFAULT (getdate()) FOR [created]
GO
ALTER TABLE [dbo].[QuizHistory]  WITH CHECK ADD  CONSTRAINT [FK_QuizHistory_Users] FOREIGN KEY([userID])
REFERENCES [dbo].[Users] ([id])
GO
ALTER TABLE [dbo].[QuizHistory] CHECK CONSTRAINT [FK_QuizHistory_Users]
GO
