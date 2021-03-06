USE [aiad049_db]
GO
/****** Object:  ForeignKey [FK__booked_se__booki__4E1E9780]    Script Date: 05/02/2013 15:56:54 ******/
ALTER TABLE [dbo].[Booked_Seats] DROP CONSTRAINT [FK__booked_se__booki__4E1E9780]
GO
/****** Object:  ForeignKey [FK__bookings__accoun__6E01572D]    Script Date: 05/02/2013 15:56:55 ******/
ALTER TABLE [dbo].[Bookings] DROP CONSTRAINT [FK__bookings__accoun__6E01572D]
GO
/****** Object:  ForeignKey [FK__bookings__refund__12FDD1B2]    Script Date: 05/02/2013 15:56:55 ******/
ALTER TABLE [dbo].[Bookings] DROP CONSTRAINT [FK__bookings__refund__12FDD1B2]
GO
/****** Object:  ForeignKey [FK__houses_ro__house__25518C17]    Script Date: 05/02/2013 15:56:56 ******/
ALTER TABLE [dbo].[Houses_Rows] DROP CONSTRAINT [FK__houses_ro__house__25518C17]
GO
/****** Object:  ForeignKey [FK__membership__role__6FE99F9F]    Script Date: 05/02/2013 15:56:57 ******/
ALTER TABLE [dbo].[Membership] DROP CONSTRAINT [FK__membership__role__6FE99F9F]
GO
/****** Object:  ForeignKey [FK__movies_au__langu__73BA3083]    Script Date: 05/02/2013 15:56:59 ******/
ALTER TABLE [dbo].[Movies_Author] DROP CONSTRAINT [FK__movies_au__langu__73BA3083]
GO
/****** Object:  ForeignKey [FK__movies_au__movie__72C60C4A]    Script Date: 05/02/2013 15:56:59 ******/
ALTER TABLE [dbo].[Movies_Author] DROP CONSTRAINT [FK__movies_au__movie__72C60C4A]
GO
/****** Object:  ForeignKey [FK__movies_de__langu__4BAC3F29]    Script Date: 05/02/2013 15:57:00 ******/
ALTER TABLE [dbo].[Movies_Description] DROP CONSTRAINT [FK__movies_de__langu__4BAC3F29]
GO
/****** Object:  ForeignKey [FK__movies_de__movie__4AB81AF0]    Script Date: 05/02/2013 15:57:00 ******/
ALTER TABLE [dbo].[Movies_Description] DROP CONSTRAINT [FK__movies_de__movie__4AB81AF0]
GO
/****** Object:  ForeignKey [FK__movies_na__langu__4D94879B]    Script Date: 05/02/2013 15:57:01 ******/
ALTER TABLE [dbo].[Movies_Name] DROP CONSTRAINT [FK__movies_na__langu__4D94879B]
GO
/****** Object:  ForeignKey [FK__movies_na__movie__4CA06362]    Script Date: 05/02/2013 15:57:01 ******/
ALTER TABLE [dbo].[Movies_Name] DROP CONSTRAINT [FK__movies_na__movie__4CA06362]
GO
/****** Object:  ForeignKey [FK__personal___accou__6EF57B66]    Script Date: 05/02/2013 15:57:02 ******/
ALTER TABLE [dbo].[Personal_Info] DROP CONSTRAINT [FK__personal___accou__6EF57B66]
GO
/****** Object:  ForeignKey [FK__showings__house___3B75D760]    Script Date: 05/02/2013 15:57:04 ******/
ALTER TABLE [dbo].[Showings] DROP CONSTRAINT [FK__showings__house___3B75D760]
GO
/****** Object:  ForeignKey [FK__showings__movie___3C69FB99]    Script Date: 05/02/2013 15:57:04 ******/
ALTER TABLE [dbo].[Showings] DROP CONSTRAINT [FK__showings__movie___3C69FB99]
GO
/****** Object:  Check [CK__membershi__login__32767D0B]    Script Date: 05/02/2013 15:56:57 ******/
ALTER TABLE [dbo].[Membership] DROP CONSTRAINT [CK__membershi__login__32767D0B]
GO
/****** Object:  Check [CK__personal___user___607251E5]    Script Date: 05/02/2013 15:57:02 ******/
ALTER TABLE [dbo].[Personal_Info] DROP CONSTRAINT [CK__personal___user___607251E5]
GO
/****** Object:  StoredProcedure [dbo].[show_Movie]    Script Date: 05/02/2013 15:56:50 ******/
DROP PROCEDURE [dbo].[show_Movie]
GO
/****** Object:  View [dbo].[view_PersonalStatementMonthly]    Script Date: 05/02/2013 15:57:06 ******/
DROP VIEW [dbo].[view_PersonalStatementMonthly]
GO
/****** Object:  View [dbo].[view_PersonalStatementYearly]    Script Date: 05/02/2013 15:57:06 ******/
DROP VIEW [dbo].[view_PersonalStatementYearly]
GO
/****** Object:  UserDefinedFunction [dbo].[check_SeatStatus]    Script Date: 05/02/2013 15:57:05 ******/
DROP FUNCTION [dbo].[check_SeatStatus]
GO
/****** Object:  StoredProcedure [dbo].[show_X_BookedSeat]    Script Date: 05/02/2013 15:56:51 ******/
DROP PROCEDURE [dbo].[show_X_BookedSeat]
GO
/****** Object:  StoredProcedure [dbo].[insert_Booking]    Script Date: 05/02/2013 15:56:47 ******/
DROP PROCEDURE [dbo].[insert_Booking]
GO
/****** Object:  StoredProcedure [dbo].[insert_User]    Script Date: 05/02/2013 15:56:48 ******/
DROP PROCEDURE [dbo].[insert_User]
GO
/****** Object:  StoredProcedure [dbo].[show_Showing]    Script Date: 05/02/2013 15:56:50 ******/
DROP PROCEDURE [dbo].[show_Showing]
GO
/****** Object:  UserDefinedFunction [dbo].[test_dateDiff]    Script Date: 05/02/2013 15:57:06 ******/
DROP FUNCTION [dbo].[test_dateDiff]
GO
/****** Object:  UserDefinedFunction [dbo].[check_isShowingMovie]    Script Date: 05/02/2013 15:57:05 ******/
DROP FUNCTION [dbo].[check_isShowingMovie]
GO
/****** Object:  View [dbo].[check_HouseSeat]    Script Date: 05/02/2013 15:57:06 ******/
DROP VIEW [dbo].[check_HouseSeat]
GO
/****** Object:  StoredProcedure [dbo].[insert_Showing]    Script Date: 05/02/2013 15:56:48 ******/
DROP PROCEDURE [dbo].[insert_Showing]
GO
/****** Object:  StoredProcedure [dbo].[delete_User]    Script Date: 05/02/2013 15:56:46 ******/
DROP PROCEDURE [dbo].[delete_User]
GO
/****** Object:  StoredProcedure [dbo].[update_User]    Script Date: 05/02/2013 15:56:53 ******/
DROP PROCEDURE [dbo].[update_User]
GO
/****** Object:  StoredProcedure [dbo].[delete_Movie]    Script Date: 05/02/2013 15:56:46 ******/
DROP PROCEDURE [dbo].[delete_Movie]
GO
/****** Object:  StoredProcedure [dbo].[update_Movie]    Script Date: 05/02/2013 15:56:53 ******/
DROP PROCEDURE [dbo].[update_Movie]
GO
/****** Object:  StoredProcedure [dbo].[i_______________________]    Script Date: 05/02/2013 15:56:46 ******/
DROP PROCEDURE [dbo].[i_______________________]
GO
/****** Object:  StoredProcedure [dbo].[d_______________________]    Script Date: 05/02/2013 15:56:45 ******/
DROP PROCEDURE [dbo].[d_______________________]
GO
/****** Object:  StoredProcedure [dbo].[s_______________________]    Script Date: 05/02/2013 15:56:48 ******/
DROP PROCEDURE [dbo].[s_______________________]
GO
/****** Object:  StoredProcedure [dbo].[test_p]    Script Date: 05/02/2013 15:56:52 ******/
DROP PROCEDURE [dbo].[test_p]
GO
/****** Object:  StoredProcedure [dbo].[u_______________________]    Script Date: 05/02/2013 15:56:52 ******/
DROP PROCEDURE [dbo].[u_______________________]
GO
/****** Object:  StoredProcedure [dbo].[insert_Movie]    Script Date: 05/02/2013 15:56:47 ******/
DROP PROCEDURE [dbo].[insert_Movie]
GO
/****** Object:  View [dbo].[allFunction]    Script Date: 05/02/2013 15:57:06 ******/
DROP VIEW [dbo].[allFunction]
GO
/****** Object:  StoredProcedure [dbo].[update_Showing]    Script Date: 05/02/2013 15:56:53 ******/
DROP PROCEDURE [dbo].[update_Showing]
GO
/****** Object:  StoredProcedure [dbo].[delete_Showing]    Script Date: 05/02/2013 15:56:46 ******/
DROP PROCEDURE [dbo].[delete_Showing]
GO
/****** Object:  StoredProcedure [dbo].[insert_HouseSeat]    Script Date: 05/02/2013 15:56:47 ******/
DROP PROCEDURE [dbo].[insert_HouseSeat]
GO
/****** Object:  StoredProcedure [dbo].[show_House]    Script Date: 05/02/2013 15:56:49 ******/
DROP PROCEDURE [dbo].[show_House]
GO
/****** Object:  StoredProcedure [dbo].[delete_House]    Script Date: 05/02/2013 15:56:46 ******/
DROP PROCEDURE [dbo].[delete_House]
GO
/****** Object:  StoredProcedure [dbo].[update_HouseSeat]    Script Date: 05/02/2013 15:56:53 ******/
DROP PROCEDURE [dbo].[update_HouseSeat]
GO
/****** Object:  StoredProcedure [dbo].[insert_ShowingSeat]    Script Date: 05/02/2013 15:56:48 ******/
DROP PROCEDURE [dbo].[insert_ShowingSeat]
GO
/****** Object:  StoredProcedure [dbo].[show_ShowingSeat]    Script Date: 05/02/2013 15:56:51 ******/
DROP PROCEDURE [dbo].[show_ShowingSeat]
GO
/****** Object:  StoredProcedure [dbo].[delete_HouseSeat]    Script Date: 05/02/2013 15:56:46 ******/
DROP PROCEDURE [dbo].[delete_HouseSeat]
GO
/****** Object:  StoredProcedure [dbo].[delete_Booking]    Script Date: 05/02/2013 15:56:45 ******/
DROP PROCEDURE [dbo].[delete_Booking]
GO
/****** Object:  StoredProcedure [dbo].[update_BookingStatus]    Script Date: 05/02/2013 15:56:52 ******/
DROP PROCEDURE [dbo].[update_BookingStatus]
GO
/****** Object:  StoredProcedure [dbo].[show_Booking]    Script Date: 05/02/2013 15:56:49 ******/
DROP PROCEDURE [dbo].[show_Booking]
GO
/****** Object:  StoredProcedure [dbo].[update_HouseName]    Script Date: 05/02/2013 15:56:52 ******/
DROP PROCEDURE [dbo].[update_HouseName]
GO
/****** Object:  StoredProcedure [dbo].[show_HouseSeat]    Script Date: 05/02/2013 15:56:49 ******/
DROP PROCEDURE [dbo].[show_HouseSeat]
GO
/****** Object:  StoredProcedure [dbo].[show_User]    Script Date: 05/02/2013 15:56:51 ******/
DROP PROCEDURE [dbo].[show_User]
GO
/****** Object:  StoredProcedure [dbo].[show_UserLoyalty]    Script Date: 05/02/2013 15:56:51 ******/
DROP PROCEDURE [dbo].[show_UserLoyalty]
GO
/****** Object:  StoredProcedure [dbo].[show_BookingGrouped]    Script Date: 05/02/2013 15:56:49 ******/
DROP PROCEDURE [dbo].[show_BookingGrouped]
GO
/****** Object:  StoredProcedure [dbo].[show_ShowingSales]    Script Date: 05/02/2013 15:56:50 ******/
DROP PROCEDURE [dbo].[show_ShowingSales]
GO
/****** Object:  StoredProcedure [dbo].[show_X_Booking]    Script Date: 05/02/2013 15:56:52 ******/
DROP PROCEDURE [dbo].[show_X_Booking]
GO
/****** Object:  StoredProcedure [dbo].[show_HouseSales]    Script Date: 05/02/2013 15:56:49 ******/
DROP PROCEDURE [dbo].[show_HouseSales]
GO
/****** Object:  StoredProcedure [dbo].[show_SeatQueue]    Script Date: 05/02/2013 15:56:50 ******/
DROP PROCEDURE [dbo].[show_SeatQueue]
GO
/****** Object:  StoredProcedure [dbo].[insert_SeatQueue]    Script Date: 05/02/2013 15:56:47 ******/
DROP PROCEDURE [dbo].[insert_SeatQueue]
GO
/****** Object:  StoredProcedure [dbo].[delete_SeatQueue]    Script Date: 05/02/2013 15:56:46 ******/
DROP PROCEDURE [dbo].[delete_SeatQueue]
GO
/****** Object:  StoredProcedure [dbo].[searchPhoneRecord]    Script Date: 05/02/2013 15:56:48 ******/
DROP PROCEDURE [dbo].[searchPhoneRecord]
GO
/****** Object:  Table [dbo].[users]    Script Date: 05/02/2013 15:57:05 ******/
DROP TABLE [dbo].[users]
GO
/****** Object:  Table [dbo].[userroles]    Script Date: 05/02/2013 15:57:05 ******/
DROP TABLE [dbo].[userroles]
GO
/****** Object:  View [dbo].[allTable]    Script Date: 05/02/2013 15:57:06 ******/
DROP VIEW [dbo].[allTable]
GO
/****** Object:  View [dbo].[allProcedure]    Script Date: 05/02/2013 15:57:06 ******/
DROP VIEW [dbo].[allProcedure]
GO
/****** Object:  StoredProcedure [dbo].[delete_Booking_Hard]    Script Date: 05/02/2013 15:56:45 ******/
DROP PROCEDURE [dbo].[delete_Booking_Hard]
GO
/****** Object:  Table [dbo].[Ref_Role]    Script Date: 05/02/2013 15:57:03 ******/
DROP TABLE [dbo].[Ref_Role]
GO
/****** Object:  Table [dbo].[Ref_Payment_Status]    Script Date: 05/02/2013 15:57:03 ******/
DROP TABLE [dbo].[Ref_Payment_Status]
GO
/****** Object:  Table [dbo].[Movies]    Script Date: 05/02/2013 15:56:59 ******/
DROP TABLE [dbo].[Movies]
GO
/****** Object:  Table [dbo].[Movies_Name]    Script Date: 05/02/2013 15:57:00 ******/
DROP TABLE [dbo].[Movies_Name]
GO
/****** Object:  Table [dbo].[Houses]    Script Date: 05/02/2013 15:56:56 ******/
DROP TABLE [dbo].[Houses]
GO
/****** Object:  Table [dbo].[Showings]    Script Date: 05/02/2013 15:57:04 ******/
DROP TABLE [dbo].[Showings]
GO
/****** Object:  Table [dbo].[Houses_Rows]    Script Date: 05/02/2013 15:56:56 ******/
DROP TABLE [dbo].[Houses_Rows]
GO
/****** Object:  Table [dbo].[Movies_Description]    Script Date: 05/02/2013 15:57:00 ******/
DROP TABLE [dbo].[Movies_Description]
GO
/****** Object:  Table [dbo].[Ref_Language]    Script Date: 05/02/2013 15:57:02 ******/
DROP TABLE [dbo].[Ref_Language]
GO
/****** Object:  Table [dbo].[Movies_Author]    Script Date: 05/02/2013 15:56:59 ******/
DROP TABLE [dbo].[Movies_Author]
GO
/****** Object:  Table [dbo].[Booked_Seats]    Script Date: 05/02/2013 15:56:54 ******/
DROP TABLE [dbo].[Booked_Seats]
GO
/****** Object:  Table [dbo].[Bookings]    Script Date: 05/02/2013 15:56:55 ******/
DROP TABLE [dbo].[Bookings]
GO
/****** Object:  Table [dbo].[Personal_Info]    Script Date: 05/02/2013 15:57:01 ******/
DROP TABLE [dbo].[Personal_Info]
GO
/****** Object:  Table [dbo].[Membership]    Script Date: 05/02/2013 15:56:57 ******/
DROP TABLE [dbo].[Membership]
GO
/****** Object:  Table [dbo].[Ticket_Queue]    Script Date: 05/02/2013 15:57:04 ******/
DROP TABLE [dbo].[Ticket_Queue]
GO
/****** Object:  Table [dbo].[phonebook]    Script Date: 05/02/2013 15:57:02 ******/
DROP TABLE [dbo].[phonebook]
GO
/****** Object:  UserDefinedFunction [dbo].[test_dateDiff]    Script Date: 05/02/2013 15:57:06 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE function [dbo].[test_dateDiff]
(
	@showTime datetime,
	@now datetime
)
	RETURNS int
AS
BEGIN
	DECLARE @counting int
	SET @counting=	(DATEDIFF(YY, @showTime, @now)-
					(CASE
						WHEN @now >= DATEADD(YY, DATEDIFF(YY, @showTime, @now), @showTime) THEN 0
						ELSE 1
					END))
	RETURN @counting
END
GO
/****** Object:  Table [dbo].[Houses]    Script Date: 05/02/2013 15:56:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Houses](
	[house_id] [int] IDENTITY(1,1) NOT NULL,
	[house_name] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[house_capacity] [int] NOT NULL,
	[active] [int] NULL CONSTRAINT [DF__houses__active__43A1090D]  DEFAULT (1),
 CONSTRAINT [PK__Houses__117F9D94] PRIMARY KEY CLUSTERED 
(
	[house_id] ASC
) ON [PRIMARY],
 CONSTRAINT [UQ__houses__75A278F5] UNIQUE NONCLUSTERED 
(
	[house_id] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Ref_Payment_Status]    Script Date: 05/02/2013 15:57:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ref_Payment_Status](
	[payment_status] [varchar](20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT [PK__Ref_Refund_Statu__1209AD79] PRIMARY KEY CLUSTERED 
(
	[payment_status] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  View [dbo].[allFunction]    Script Date: 05/02/2013 15:57:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE view [dbo].[allFunction]
as
select routine_name from information_schema.routines where routine_type='function'
GO
/****** Object:  StoredProcedure [dbo].[i_______________________]    Script Date: 05/02/2013 15:56:46 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[i_______________________]
AS
BEGIN
	select getdate()
END
GO
/****** Object:  StoredProcedure [dbo].[d_______________________]    Script Date: 05/02/2013 15:56:45 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[d_______________________]
AS
BEGIN
	select getdate()
END
GO
/****** Object:  StoredProcedure [dbo].[s_______________________]    Script Date: 05/02/2013 15:56:48 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[s_______________________]
AS
BEGIN
	select getdate()
END
GO
/****** Object:  StoredProcedure [dbo].[u_______________________]    Script Date: 05/02/2013 15:56:52 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[u_______________________]
AS
BEGIN
	select getdate()
END
GO
/****** Object:  Table [dbo].[Ref_Role]    Script Date: 05/02/2013 15:57:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ref_Role](
	[role] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT [PK__ref_membership_r__5BE2A6F2] PRIMARY KEY CLUSTERED 
(
	[role] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Ref_Language]    Script Date: 05/02/2013 15:57:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ref_Language](
	[language_code] [varchar](3) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[language] [varchar](40) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT [PK__Ref_Language__4316F928] PRIMARY KEY CLUSTERED 
(
	[language_code] ASC
) ON [PRIMARY],
 CONSTRAINT [UQ__ref_language__5812160E] UNIQUE NONCLUSTERED 
(
	[language] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[delete_Booking]    Script Date: 05/02/2013 15:56:45 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[delete_Booking]
	@booking_id int
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	SET NOCOUNT ON
	UPDATE	Bookings
	SET		payment_status = 'Payment Cancel'
	WHERE	@booking_id = booking_id
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  Table [dbo].[Ticket_Queue]    Script Date: 05/02/2013 15:57:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ticket_Queue](
	[showing_id] [int] NOT NULL,
	[row_number] [int] NOT NULL,
	[seat_number] [int] NOT NULL,
	[booking_id] [int] NOT NULL,
 CONSTRAINT [PK__Ticket_Queue__66EA454A] PRIMARY KEY CLUSTERED 
(
	[showing_id] ASC,
	[row_number] ASC,
	[seat_number] ASC,
	[booking_id] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 05/02/2013 15:57:05 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[users](
	[username] [varchar](8) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[password] [varchar](32) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[userroles]    Script Date: 05/02/2013 15:57:05 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[userroles](
	[username] [varchar](8) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[rolename] [varchar](8) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  View [dbo].[allTable]    Script Date: 05/02/2013 15:57:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[allTable] as 
select * from information_schema.tables
GO
/****** Object:  View [dbo].[allProcedure]    Script Date: 05/02/2013 15:57:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[allProcedure] as
select specific_name from information_schema.routines where routine_type='procedure'
GO
/****** Object:  Table [dbo].[Movies]    Script Date: 05/02/2013 15:56:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movies](
	[movie_id] [int] IDENTITY(1,1) NOT NULL,
	[movie_duration] [int] NOT NULL CONSTRAINT [DF__movies__movie_du__59C55456]  DEFAULT (60),
	[movie_startDate] [datetime] NOT NULL CONSTRAINT [DF__movies__movie_st__5AB9788F]  DEFAULT (getdate()),
	[movie_endDate] [datetime] NOT NULL CONSTRAINT [DF__movies__movie_en__719CDDE7]  DEFAULT (dateadd(day,30,getdate())),
	[active] [int] NULL CONSTRAINT [DF__movies__active__4589517F]  DEFAULT (1),
 CONSTRAINT [PK_Movies] PRIMARY KEY CLUSTERED 
(
	[movie_id] ASC
) ON [PRIMARY],
 CONSTRAINT [UQ__movies__74AE54BC] UNIQUE NONCLUSTERED 
(
	[movie_id] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[phonebook]    Script Date: 05/02/2013 15:57:02 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[phonebook](
	[UID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[Phone] [varchar](8) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT [PK__phonebook__76CBA758] PRIMARY KEY CLUSTERED 
(
	[UID] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Houses_Rows]    Script Date: 05/02/2013 15:56:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Houses_Rows](
	[house_id] [int] NOT NULL,
	[row_number] [int] NOT NULL,
	[seat_number] [int] NOT NULL,
	[active] [int] NULL CONSTRAINT [DF__houses_ro__activ__4959E263]  DEFAULT (1),
 CONSTRAINT [PK__houses_rows__4D2A7347] PRIMARY KEY CLUSTERED 
(
	[house_id] ASC,
	[row_number] ASC,
	[seat_number] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
CREATE NONCLUSTERED INDEX [index_SeatID] ON [dbo].[Houses_Rows] 
(
	[row_number] ASC,
	[house_id] ASC,
	[seat_number] ASC
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Showings]    Script Date: 05/02/2013 15:57:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Showings](
	[showing_id] [int] IDENTITY(1,1) NOT NULL,
	[house_id] [int] NOT NULL,
	[movie_id] [int] NOT NULL,
	[showing_time] [datetime] NOT NULL,
	[ticket_price] [int] NOT NULL CONSTRAINT [DF__showings__ticket__214BF109]  DEFAULT (60),
	[active] [int] NULL CONSTRAINT [DF__showings__active__44952D46]  DEFAULT (1),
 CONSTRAINT [PK__showings__7C4F7684] PRIMARY KEY CLUSTERED 
(
	[house_id] ASC,
	[showing_time] ASC
) ON [PRIMARY],
 CONSTRAINT [UQ__showings__797309D9] UNIQUE NONCLUSTERED 
(
	[showing_id] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bookings]    Script Date: 05/02/2013 15:56:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Bookings](
	[booking_id] [int] IDENTITY(1,1) NOT NULL,
	[account_id] [int] NULL,
	[booking_madeDate] [datetime] NOT NULL CONSTRAINT [DF__bookings__bookin__1A9EF37A]  DEFAULT (getdate()),
	[payment_status] [varchar](20) COLLATE SQL_Latin1_General_CP1_CI_AS NULL CONSTRAINT [DF__bookings__bookin__467D75B8]  DEFAULT ('Payment Incomplete'),
	[guest_email] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
 CONSTRAINT [PK__bookings__6BE40491] PRIMARY KEY CLUSTERED 
(
	[booking_id] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Membership]    Script Date: 05/02/2013 15:56:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Membership](
	[account_id] [int] IDENTITY(1,1) NOT NULL,
	[login_id] [varchar](50) COLLATE Latin1_General_CS_AS NOT NULL,
	[login_pw] [varchar](50) COLLATE Latin1_General_CS_AS NOT NULL,
	[role] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT [PK__Membership__6C190EBB] PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
) ON [PRIMARY],
 CONSTRAINT [UQ__membership__318258D2] UNIQUE NONCLUSTERED 
(
	[login_id] ASC
) ON [PRIMARY],
 CONSTRAINT [UQ__membership__778AC167] UNIQUE NONCLUSTERED 
(
	[account_id] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
CREATE NONCLUSTERED INDEX [index_loginID] ON [dbo].[Membership] 
(
	[login_id] ASC
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Personal_Info]    Script Date: 05/02/2013 15:57:01 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Personal_Info](
	[account_id] [int] NOT NULL,
	[user_name] [nvarchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[user_phone] [varchar](20) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[user_email] [varchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[loyalty_point] [int] NULL CONSTRAINT [DF__personal___loyal__5F492382]  DEFAULT (0),
 CONSTRAINT [PK__Personal_Info__628FA481] PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
) ON [PRIMARY],
 CONSTRAINT [UQ__personal_info__787EE5A0] UNIQUE NONCLUSTERED 
(
	[account_id] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Movies_Name]    Script Date: 05/02/2013 15:57:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Movies_Name](
	[movie_id] [int] NOT NULL,
	[language_code] [varchar](3) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[movie_name] [nvarchar](255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT [PK__Movies_Name__47DBAE45] PRIMARY KEY CLUSTERED 
(
	[movie_id] ASC,
	[language_code] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Movies_Description]    Script Date: 05/02/2013 15:57:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Movies_Description](
	[movie_id] [int] NOT NULL,
	[language_code] [varchar](3) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[movie_description] [nvarchar](255) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
 CONSTRAINT [PK__Movies_Descripti__44FF419A] PRIMARY KEY CLUSTERED 
(
	[movie_id] ASC,
	[language_code] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Movies_Author]    Script Date: 05/02/2013 15:56:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Movies_Author](
	[movie_id] [int] NOT NULL,
	[language_code] [varchar](3) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[movie_author] [nvarchar](50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
 CONSTRAINT [PK__Movies_Author__71D1E811] PRIMARY KEY CLUSTERED 
(
	[movie_id] ASC,
	[language_code] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Booked_Seats]    Script Date: 05/02/2013 15:56:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Booked_Seats](
	[showing_id] [int] NOT NULL,
	[row_number] [int] NOT NULL,
	[seat_number] [int] NOT NULL,
	[booking_id] [int] NOT NULL,
 CONSTRAINT [PK__booked_seats__57A801BA] PRIMARY KEY CLUSTERED 
(
	[showing_id] ASC,
	[booking_id] ASC,
	[seat_number] ASC,
	[row_number] ASC
) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  StoredProcedure [dbo].[delete_HouseSeat]    Script Date: 05/02/2013 15:56:46 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[delete_HouseSeat]
	@house_id int
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	DECLARE @c0 int
	SET @c0 = (
		SELECT	house_capacity
		FROM	Houses
		WHERE	@house_id = house_id
	)

	SET NOCOUNT ON
	------------------------------
	DELETE	Houses_Rows
	WHERE	@house_id = house_id
	SET @row = @row + @@rowcount
	-------------------------------
	SET NOCOUNT OFF

	IF @row = @c0
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[update_HouseName]    Script Date: 05/02/2013 15:56:52 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[update_HouseName]
	@house_id int,
	@house_name varchar(30)
AS
BEGIN
	SET NOCOUNT ON
	DECLARE @row int
	SET @row = 0
	
	UPDATE	Houses
	SET		house_name = @house_name
	WHERE	@house_id = house_id
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[show_HouseSales]    Script Date: 05/02/2013 15:56:49 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_HouseSales]
	@house_id int = NULL
AS
BEGIN
	SELECT	a.house_id,
			isNull(sum(a.ticket_price * b.num), 0) as sales,
			count(*) as num_of_show
	FROM
	(	SELECT	p.house_id,
				q.showing_id,
				q.ticket_price
		FROM	Houses p
		LEFT JOIN
				Showings q
		ON		p.house_id = q.house_id
	) a
	LEFT JOIN
	(	SELECT	f.showing_id,
				count(*) as num
		FROM	Booked_Seats f,
				Bookings g
		WHERE	f.booking_id = g.booking_id AND
				g.payment_status IN ('Payment Complete', 'Refund Pending', 'Refund Declined')
		GROUP BY
				f.showing_id
	) b
	ON		a.showing_id = b.showing_id
	WHERE	@house_id IN (NULL, a.house_id)
	GROUP BY
			a.house_id
END
GO
/****** Object:  StoredProcedure [dbo].[delete_House]    Script Date: 05/02/2013 15:56:46 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[delete_House]
	@house_id int
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	SET NOCOUNT ON
	UPDATE	Houses
	SET		active = 0
	WHERE	@house_id = house_id
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[insert_HouseSeat]    Script Date: 05/02/2013 15:56:47 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[insert_HouseSeat]
	@house_name varchar(50) = NULL,
	@capacity int,
	@row_num int,
	@house_id int = NULL
AS
BEGIN
	DECLARE @row int
	SET @row = 0
	--------------------------
	DECLARE @c1 int
	DECLARE @c2 int
	DECLARE @c3 int
	DECLARE @max int
	--------------------------
	SET @c1 = @row_num
	SET @c2 = @capacity % @row_num
	SET @max = @capacity / @row_num
	--------------------------
	SET NOCOUNT ON
	--------------------------
	IF @house_id IS NULL
	BEGIN
		SET @house_id = (
			SELECT	max(house_id)
			FROM	Houses )
		SET @house_id = @house_id + 1
		SET IDENTITY_INSERT Houses ON
		INSERT
		INTO	Houses
				(house_name, house_id, house_capacity)
		VALUES	(@house_name, @house_id, @capacity)
		SET @row = @row + @@rowcount
		SET IDENTITY_INSERT Houses OFF
	END
	ELSE
	BEGIN
		UPDATE	Houses
		SET		house_name = CASE WHEN @house_name IS NULL THEN house_name ELSE @house_name END,
				house_capacity = @capacity
		WHERE	@house_id = house_id
		SET @row = @row + @@rowcount
	END
	-----------------------------
	WHILE @c1 > 0
	BEGIN
		SET @c3 = 1
		IF @c2 > 0
		BEGIN
			WHILE @c3 <= @max + 1
			BEGIN
				INSERT
				INTO	Houses_Rows
						(house_id, row_number, seat_number)
				VALUES	(@house_id, @c1, @c3)
				SET @row = @row + @@rowcount
				SET @c3 = @c3 + 1
			END
			SET @c2 = @c2 - 1
		END
		ELSE
		BEGIN
			WHILE @c3 <= @max
			BEGIN
				INSERT
				INTO	Houses_Rows
						(house_id, row_number, seat_number)
				VALUES	(@house_id, @c1, @c3)
				SET @row = @row + @@rowcount
				SET @c3 = @c3 + 1
			END
		END
		SET @c1 = @c1 - 1
	END
	-----------------------------
	SET NOCOUNT OFF

	IF @row = @capacity + 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[show_House]    Script Date: 05/02/2013 15:56:49 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_House]
	@house_id int = NULL
AS
BEGIN
	SELECT	a.house_id,
			a.house_name,
			a.house_capacity,
			b.total_row
	FROM	Houses a
	JOIN
	(	SELECT	house_id as house_id,
				sum(active) as house_capacity,
				max(row_number) as total_row
		FROM	Houses_Rows
		GROUP BY
				house_id
	) b
	ON		a.house_id = b.house_id
	WHERE	@house_id IN (NULL, a.house_id) AND
			a.active = 1
END
GO
/****** Object:  View [dbo].[check_HouseSeat]    Script Date: 05/02/2013 15:57:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE view [dbo].[check_HouseSeat]
as
SELECT	a.house_id as house_id,
		a.house_name as house_name,
		a.house_capacity as house_capacity,
		count(b.row_number) as total_row,
		sum(b.row_max) as total_seat
FROM	Houses a,
		Houses_Rows b
WHERE	a.house_id = b.house_id
GROUP BY
		a.house_id,
		a.house_name,
		a.house_capacity
GO
/****** Object:  StoredProcedure [dbo].[show_Showing]    Script Date: 05/02/2013 15:56:50 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_Showing]
	@day int = NULL,
	@time datetime = NULL,
	@house_id int = NULL,
	@movie_id int = NULL,
	@lang varchar(3) = NULL,
	@showing_id int = NULL
AS
BEGIN
	IF @lang IS NULL
		SET @lang = 'en'
	IF @time IS NULL
	BEGIN
		SET @time = getdate()
		SET @time = dateadd(hour, -datepart(hour, @time), @time)
		SET @time = dateadd(minute, -datepart(minute, @time), @time)
		SET @time = dateadd(second, -datepart(second, @time), @time)
	END

	SELECT	a.house_id as house_id,
			a.showing_id as showing_id,
			b.movie_id as movie_id,
			d.movie_name as movie_name,
			c.house_name as house_name,
			convert(varchar(12), a.showing_time, 102) as showing_startDate,
			right(replicate('0',1) + convert(varchar(2), datepart(hour, a.showing_time)),2) + ':' + right(replicate('0',1) + convert(varchar(2), datepart(minute, a.showing_time)),2) as showing_startTime,
			convert(varchar(12), dateadd(minute, b.movie_duration, a.showing_time), 102) as showing_endDate,
			right(replicate('0',1) + convert(varchar(2), datepart(hour, dateadd(minute, b.movie_duration, a.showing_time))),2) + ':'+ right(replicate('0',1) + convert(varchar(2), datepart(minute, dateadd(minute, b.movie_duration, a.showing_time))),2) as showing_endTime,
			a.ticket_price as ticket_price
	FROM	Showings a,
			Movies b,
			Houses c,
			Movies_Name d
	WHERE	a.movie_id = b.movie_id AND
			b.movie_id = d.movie_id AND
			a.house_id = c.house_id AND
		----------- WHEN @day != 0
			@time <= CASE WHEN @day = 0 THEN @time ELSE a.showing_time END AND

			CASE WHEN @day = 0 THEN 1 ELSE 
				CASE WHEN @day IS NULL THEN 1 ELSE dateadd(hour, 24*@day, @time) END
				END
			>=
			CASE WHEN @day = 0 THEN 1 ELSE
				CASE WHEN @day IS NULL THEN 1 ELSE a.showing_time END
				END AND
		----------- WHEN @day == 0
			a.showing_time <= CASE WHEN @day = 0 THEN @time ELSE a.showing_time END AND
			@time <= CASE WHEN @day = 0 THEN dateadd(minute, b.movie_duration, a.showing_time) ELSE @time END AND
		----------- END
			@house_id IN (a.house_id, NULL) AND
			@movie_id IN (b.movie_id, NULL) AND
			d.language_code = @lang AND
			@showing_id IN (NULL, a.showing_id) AND
			a.active = 1
	ORDER BY
			showing_startDate, showing_startTime, c.house_name
END
GO
/****** Object:  UserDefinedFunction [dbo].[check_isShowingMovie]    Script Date: 05/02/2013 15:57:05 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE function [dbo].[check_isShowingMovie]
(
	@house_id int,
	@time datetime
)
	RETURNS int
AS
BEGIN
	DECLARE @count int
/**/
	SET @count = 
		CASE (	SELECT	count(*)
				FROM	Showings a, Movies b
				WHERE	a.movie_id = b.movie_id and
						a.house_id = @house_id and
						@time >= a.showing_time and
						@time < dateadd(minute, b.movie_duration, a.showing_time)
				GROUP BY
						house_id
				)
			WHEN 1 THEN 1
			ELSE 0
		END
/**
	SET @count = (	SELECT	count(*)
					FROM	Showings a, Movies b
					WHERE	a.movie_id = b.movie_id and
							a.house_id = @house_id and
							@time >= a.showing_time and
							@time < dateadd(minute, b.movie_duration, a.showing_time)
					GROUP BY
							house_id )
**/
	RETURN @count
END
GO
/****** Object:  View [dbo].[view_PersonalStatementMonthly]    Script Date: 05/02/2013 15:57:06 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE View [dbo].[view_PersonalStatementMonthly]
as
SELECT     a.account_id, DATEPART(year, d.showing_time) AS yearNum, DATEPART(month, d.showing_time) AS monthNum, SUM(d.ticket_price * c.discount_percent / 100) 
                      AS monthly_spent
FROM         dbo.Membership AS a INNER JOIN
                      dbo.Bookings AS b ON a.account_id = b.account_id INNER JOIN
                      dbo.Booked_Seats AS c ON b.booking_id = c.booking_id INNER JOIN
                      dbo.Showings AS d ON c.showing_id = d.showing_id
WHERE     (b.refund_status IN (NULL, 'cancel'))
GROUP BY a.account_id, DATEPART(year, d.showing_time), DATEPART(month, d.showing_time)
GO
/****** Object:  View [dbo].[view_PersonalStatementYearly]    Script Date: 05/02/2013 15:57:06 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE View [dbo].[view_PersonalStatementYearly]
as
SELECT     a.account_id, DATEPART(year, d.showing_time) AS yearNum, SUM(d.ticket_price * c.discount_percent / 100) AS year_spent
FROM         dbo.Membership AS a INNER JOIN
                      dbo.Bookings AS b ON a.account_id = b.account_id INNER JOIN
                      dbo.Booked_Seats AS c ON b.booking_id = c.booking_id INNER JOIN
                      dbo.Showings AS d ON c.showing_id = d.showing_id
WHERE     (b.refund_status IN (NULL, 'cancel'))
GROUP BY a.account_id, DATEPART(year, d.showing_time)
GO
/****** Object:  UserDefinedFunction [dbo].[check_SeatStatus]    Script Date: 05/02/2013 15:57:05 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE function [dbo].[check_SeatStatus]
(
	@showing_id int,
	@row int,
	@seat int,
	@house_id int = NULL
)
	RETURNS int
AS
BEGIN
	DECLARE @count int
	SET @count = 
		CASE (	SELECT	count(*)
				FROM	Booked_Seats a,
						Showings b
				WHERE	a.showing_id = b.showing_id AND
						@showing_id = a.showing_id AND
						@house_id IN (b.house_id, 0) AND
						@row = a.row_number AND
						@seat = a.seat_number
			)
			WHEN 1 THEN 1
			ELSE 0
		END
	RETURN @count
END
GO
/****** Object:  StoredProcedure [dbo].[show_X_BookedSeat]    Script Date: 05/02/2013 15:56:51 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_X_BookedSeat]
	@showing_id int = NULL
AS
BEGIN
	SELECT	b.house_id as house_id,
			a.showing_id as showing_id,
			a.booking_id as booking_id,
			a.row_number as row_number,
			a.seat_number as seat_number,
			c.booking_status as booking_status
	FROM	Booked_Seats a,
			Showings b,
			Bookings c
	WHERE	a.showing_id = b.showing_id AND
			a.booking_id = c.booking_id AND
			@showing_id IN (a.showing_id, NULL) AND
			c.booking_status IN ('Payemnt Complelte', 'Payment Incomplete', 'Refund Pending', 'Refund Declined', 'Refund Cancel') AND
			a.booking_id IS NOT NULL
	ORDER BY
			b.house_id,
			a.showing_id,
			a.row_number,
			a.seat_number
END
GO
/****** Object:  StoredProcedure [dbo].[delete_Showing]    Script Date: 05/02/2013 15:56:46 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[delete_Showing]
	@showing_id int
AS
BEGIN
	DECLARE @row int
	SET @row = 0
	
	SET NOCOUNT ON
	UPDATE	Showings
	SET		active = 0
	WHERE	@showing_id = showing_id
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[insert_Showing]    Script Date: 05/02/2013 15:56:48 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[insert_Showing]
	@house_id int,
	@movie_id int,
	@time datetime,
	@price int = NULL
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	SET NOCOUNT ON
	IF @price IS NULL
		SET @price = 60

	DECLARE @id int
	SET @id = (	SELECT	MAX(showing_id)
				FROM	Showings )
	SET @id = @id + 1

	SET IDENTITY_INSERT Showings ON
	INSERT
	INTO	Showings
			(showing_id, house_id, movie_id, showing_time, ticket_price)
	VALUES	(@id, @house_id, @movie_id, @time, @price)
	SET @row = @row + @@rowcount
	SET IDENTITY_INSERT Showings OFF
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[update_HouseSeat]    Script Date: 05/02/2013 15:56:53 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[update_HouseSeat]
	@house_id int,
	@row_number int,
	@seat_number int,
	@active int
AS
BEGIN

	DECLARE @count int
	SET @count = 
		(	SELECT	COUNT(*)
			FROM	Booked_Seats a,
					Bookings b,
					Showings c
			WHERE	@house_id = c.house_id AND
					c.showing_id = a.showing_id AND
					a.booking_id = b.booking_id AND
					b.payment_status IN ('Payment Complete', 'Refund Declined', 'Refund Pending', 'Payment Incomplete') AND
					@row_number = a.row_number AND
					@seat_number = a.seat_number
			GROUP BY
					c.house_id
		)
	IF @count IS NOT NULL
		RETURN 0

	DECLARE @row int
	SET @row = 0

	SET NOCOUNT ON
	UPDATE	Houses_Rows
	SET		active = @active
	WHERE	@house_id = house_id AND
			@row_number = row_number AND
			@seat_number = seat_number
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[update_Showing]    Script Date: 05/02/2013 15:56:53 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[update_Showing]
	@showing_id int,
	@house_id int = NULL,
	@movie_id int = NULL,
	@showing_time datetime = NULL,
	@ticket_price int = NULL
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	DECLARE @count int
	SET @count = 
		(	SELECT	COUNT(*)
			FROM	Booked_Seats a,
					Bookings b
			WHERE	@showing_id = showing_id AND
					a.booking_id = b.booking_id AND
					b.payment_status IN ('Payment Complete', 'Refund Declined', 'Refund Pending', 'Payment Incomplete')
			GROUP BY
					a.showing_id
		)
	IF @count IS NOT NULL
		RETURN 0
	
	SET NOCOUNT ON
	UPDATE	Showings
	SET		house_id = CASE WHEN @house_id IS NULL THEN house_id ELSE @house_id END,
			movie_id = CASE WHEN @movie_id IS NULL THEN movie_id ELSE @movie_id END,
			showing_time = CASE WHEN @showing_time IS NULL THEN showing_time ELSE @showing_time END,
			ticket_price = CASE WHEN @ticket_price IS NULL THEN ticket_price ELSE @ticket_price END
	WHERE	@showing_id = showing_id
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[test_p]    Script Date: 05/02/2013 15:56:52 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[test_p]
	@account_id int = NULL,
	@date datetime = NULL,
	@dayBefore int = NULL,
	@booking_id int = NULL,
	@status varchar(20) = NULL,
	@guest_email varchar(50) = NULL
AS
BEGIN
	IF @dayBefore IS NULL
		SET @dayBefore = 365
	IF @date IS NULL
		SET @date = getdate()
	DECLARE @searchTime datetime
	SET @searchTime = dateadd(day, -@dayBefore, @date)

	DECLARE @now datetime
	SET @now = getdate()
	SET NOCOUNT ON
	UPDATE	Bookings
	SET		payment_status = 'Payment Timeout'
	WHERE	@now >= dateadd(minute, 5, booking_madeDate) AND
			payment_status = 'Payment Incomplete'
	SET NOCOUNT OFF

	SELECT	a.account_id as account_id,
			CASE WHEN a.account_id = 0 THEN b.guest_email ELSE NULL END as guest_email,
			b.booking_id as booking_id,
			c.showing_id as showing_id,
			convert(varchar, b.booking_madeDate, 102) as booking_madeDate,
			right(replicate('0',1) + convert(varchar(2), datepart(hour, b.booking_madeDate)),2) + ':' + right(replicate('0',1) + convert(varchar(2), datepart(minute, b.booking_madeDate)),2) as booking_madeTime,
			sum(e.ticket_price) as ticket_price,
			count(*) as num_of_ticket,
			b.payment_status as payment_status
	FROM	Personal_Info a,
			Bookings b,
			Showings e,
			(
				SELECT * FROM Booked_Seats
				UNION
				SELECT * FROM Ticket_Queue
			) c
	WHERE	(a.account_id = b.account_id OR b.account_id IS NULL) AND
			b.booking_id = c.booking_id AND
			e.showing_id = c.showing_id AND
			@searchTime <= e.showing_time AND
			@account_id IN (a.account_id, NULL) AND
			@booking_id IN (b.booking_id, NULL) AND
			@status IN (b.payment_status, NULL) AND
			@guest_email IN (NULL, '--', b.guest_email)
	GROUP BY
			b.booking_id,
			c.showing_id,
			ticket_price,
			payment_status,
			a.account_id,
			b.guest_email,
			convert(varchar, b.booking_madeDate, 102),
			right(replicate('0',1) + convert(varchar(2), datepart(hour, b.booking_madeDate)),2) + ':' + right(replicate('0',1) + convert(varchar(2), datepart(minute, b.booking_madeDate)),2)
	ORDER BY
			CASE WHEN a.account_id != 0 THEN 0 ELSE 1 END,
			account_id,
			booking_id
END
GO
/****** Object:  StoredProcedure [dbo].[show_ShowingSales]    Script Date: 05/02/2013 15:56:50 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_ShowingSales]
	@showing_id int = NULL
AS
BEGIN
	SELECT	a.showing_id,
			isNull(a.ticket_price * b.num, 0) as sales,
			isNull(b.num, 0) as ticket_sold
	FROM
	(	SELECT	showing_id,
				ticket_price
		FROM	Showings
	) a
	LEFT JOIN
	(	SELECT	f.showing_id,
				count(*) as num
		FROM	Booked_Seats f,
				Bookings g
		WHERE	f.booking_id = g.booking_id AND
				g.payment_status IN ('Payment Complete', 'Refund Pending', 'Refund Declined')
		GROUP BY
				f.showing_id
	) b
	ON		a.showing_id = b.showing_id
	WHERE	@showing_id IN (NULL, a.showing_id)
	ORDER BY
		a.showing_id
END
GO
/****** Object:  StoredProcedure [dbo].[show_X_Booking]    Script Date: 05/02/2013 15:56:52 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_X_Booking]
	@account_id int = NULL,
	@date datetime = NULL,
	@dayBefore int = NULL,
	@booking_id int = NULL,
	@status varchar(20) = NULL,
	@guest_email varchar(50) = NULL
AS
BEGIN
	IF @dayBefore IS NULL
		SET @dayBefore = 365
	IF @date IS NULL
		SET @date = getdate()
	DECLARE @searchTime datetime
	SET @searchTime = dateadd(day, -@dayBefore, @date)

	SELECT	CASE WHEN a.account_id = 0 THEN '--' ELSE convert(varchar, a.account_id) END as account_id,
			CASE WHEN a.account_id = 0 THEN 'Guest' ELSE '--' END as remark,
			b.booking_id as booking_id,
			c.showing_id as showing_id,
			e.house_id as house_id,
			convert(varchar(11), e.showing_time, 106) as showingDate,
			right(replicate('0',1) + convert(varchar(2), datepart(hour, e.showing_time)),2) + ':' + right(replicate('0',1) + convert(varchar(2), datepart(minute, e.showing_time)),2) as showingTime,
			convert(varchar(11), b.booking_madeDate, 106) as booking_madeDate,
			right(replicate('0',1) + convert(varchar(2), datepart(hour, b.booking_madeDate)),2) + ':' + right(replicate('0',1) + convert(varchar(2), datepart(minute, b.booking_madeDate)),2) as booking_madeTime,
			c.row_number as row_number,
			c.seat_number as seat_number,
			'$' + convert(varchar,e.ticket_price*c.discount_percent/100) as selling_price,
			convert(varchar(3), c.discount_percent) + '%' as discount_percent,
			isNull(b.booking_status,'--') as booking_status
	FROM	Personal_Info a,
			Bookings b,
			Booked_Seats c,
			Showings e
	WHERE	a.account_id = b.account_id AND
			b.booking_id = c.booking_id AND
			e.showing_id = c.showing_id AND
			@searchTime <= e.showing_time AND
			@account_id IN (a.account_id, NULL) AND
			@booking_id IN (b.booking_id, NULL) AND
			@status IN (b.booking_status, NULL) AND
			@guest_email IN (NULL, b.guest_email)
	ORDER BY
			CASE WHEN a.account_id != 0 THEN 0 ELSE 1 END,
			a.account_id
END
GO
/****** Object:  StoredProcedure [dbo].[show_UserLoyalty]    Script Date: 05/02/2013 15:56:51 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_UserLoyalty]
	@account_id int = NULL
AS
BEGIN
	SELECT	p.account_id,
			p.loyalty - isNull(q.loyalty, 0) as loyalty
	FROM
	(	SELECT	a.account_id,
				sum(c.ticket_price)/5 as loyalty
		FROM	Bookings a,
				Booked_Seats b,
				Showings c
		WHERE	@account_id IN (NULL, a.account_id) AND
				a.booking_id = b.booking_id AND
				b.showing_id = c.showing_id AND
				a.payment_status IN ('Payment Complete', 'HIDE', 'Refund Declined')
		GROUP BY
				a.account_id
	) p
	LEFT JOIN
	(	SELECT	a.account_id,
				sum(c.ticket_price) as loyalty
		FROM	Bookings a,
				Booked_Seats b,
				Showings c
		WHERE	@account_id IN (NULL, a.account_id) AND
				a.booking_id = b.booking_id AND
				b.showing_id = c.showing_id AND
				a.payment_status IN ('Loyalty Paid')
		GROUP BY
				a.account_id
	) q
	ON		p.account_id = q.account_id
END
GO
/****** Object:  StoredProcedure [dbo].[show_BookingGrouped]    Script Date: 05/02/2013 15:56:49 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_BookingGrouped]
	@account_id int = NULL,
	@date datetime = NULL,
	@dayBefore int = NULL,
	@booking_id int = NULL,
	@status varchar(20) = NULL,
	@guest_email varchar(50) = NULL
AS
BEGIN
	IF @dayBefore IS NULL
		SET @dayBefore = 365
	IF @date IS NULL
		SET @date = getdate()
	DECLARE @searchTime datetime
	SET @searchTime = dateadd(day, -@dayBefore, @date)

	DECLARE @now datetime
	SET @now = getdate()
	SET NOCOUNT ON
	UPDATE	Bookings
	SET		payment_status = 'Payment Timeout'
	WHERE	@now >= dateadd(minute, 5, booking_madeDate) AND
			payment_status = 'Payment Incomplete'
	SET NOCOUNT OFF


	SELECT	b.account_id as account_id,
			CASE WHEN b.account_id = 0 THEN b.guest_email ELSE NULL END as guest_email,
			b.booking_id as booking_id,
			c.showing_id as showing_id,
			convert(varchar, b.booking_madeDate, 102) as booking_madeDate,
			right(replicate('0',1) + convert(varchar(2), datepart(hour, b.booking_madeDate)),2) + ':' + right(replicate('0',1) + convert(varchar(2), datepart(minute, b.booking_madeDate)),2) as booking_madeTime,
			sum(e.ticket_price) as ticket_price,
			count(*) as num_of_ticket,
			b.payment_status as payment_status
	FROM	Bookings b
	LEFT JOIN
			(
				SELECT * FROM Booked_Seats
				UNION
				SELECT * FROM Ticket_Queue
			) c
	ON		b.booking_id = c.booking_id
	LEFT JOIN
			Showings e
	ON		c.showing_id = e.showing_id
	WHERE	(@searchTime <= e.showing_time OR e.showing_time IS NULL) AND
			@account_id IN (b.account_id, NULL) AND
			@booking_id IN (b.booking_id, NULL) AND
			@status IN (b.payment_status, NULL) AND
			@guest_email IN (NULL, b.guest_email) AND
			b.payment_status NOT IN ('HIDE')
	GROUP BY
			b.booking_id,
			c.showing_id,
			ticket_price,
			payment_status,
			b.account_id,
			b.guest_email,
			convert(varchar, b.booking_madeDate, 102),
			right(replicate('0',1) + convert(varchar(2), datepart(hour, b.booking_madeDate)),2) + ':' + right(replicate('0',1) + convert(varchar(2), datepart(minute, b.booking_madeDate)),2)
	ORDER BY
			CASE WHEN b.account_id != 0 THEN 0 ELSE 1 END,
			account_id,
			booking_id
END
GO
/****** Object:  StoredProcedure [dbo].[show_Booking]    Script Date: 05/02/2013 15:56:49 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_Booking]
	@account_id int = NULL,
	@date datetime = NULL,
	@dayBefore int = NULL,
	@booking_id int = NULL,
	@status varchar(20) = NULL,
	@guest_email varchar(50) = NULL
AS
BEGIN
	IF @dayBefore IS NULL
		SET @dayBefore = 365
	IF @date IS NULL
		SET @date = getdate()
	DECLARE @searchTime datetime
	SET @searchTime = dateadd(day, -@dayBefore, @date)

	SELECT	a.account_id as account_id,
			CASE WHEN a.account_id = 0 THEN 'Guest' ELSE NULL END as remark,
			b.booking_id as booking_id,
			e.house_id as house_id,
			convert(varchar(11), e.showing_time, 102) as showingDate,
			right(replicate('0',1) + convert(varchar(2), datepart(hour, e.showing_time)),2) + ':' + right(replicate('0',1) + convert(varchar(2), datepart(minute, e.showing_time)),2) as showingTime,
			convert(varchar(11), b.booking_madeDate, 102) as booking_madeDate,
			right(replicate('0',1) + convert(varchar(2), datepart(hour, b.booking_madeDate)),2) + ':' + right(replicate('0',1) + convert(varchar(2), datepart(minute, b.booking_madeDate)),2) as booking_madeTime,
			c.showing_id as showing_id,
			c.row_number as row_number,
			c.seat_number as seat_number,
			isNull(b.payment_status,'--') as payment_status
	FROM	Personal_Info a,
			Bookings b,
			Booked_Seats c,
			Showings e
	WHERE	a.account_id = b.account_id AND
			b.booking_id = c.booking_id AND
			e.showing_id = c.showing_id AND
			@searchTime <= e.showing_time AND
			@account_id IN (a.account_id, NULL) AND
			@booking_id IN (b.booking_id, NULL) AND
			@status IN (b.payment_status, NULL) AND
			@guest_email IN (NULL, b.guest_email)
	ORDER BY
			CASE WHEN a.account_id != 0 THEN 0 ELSE 1 END,
			a.account_id
END
GO
/****** Object:  StoredProcedure [dbo].[show_ShowingSeat]    Script Date: 05/02/2013 15:56:51 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_ShowingSeat]
	@showing_id int,
	@booking_id int = NULL,
	@row_num int = NULL,
	@seat_num int = NULL
AS
BEGIN
	SELECT	a.house_id,
			a.row_number,
			a.seat_number,
			CASE WHEN b.payment_status = 'Refund Pending' THEN NULL ELSE b.booking_id END as booking_id,
			CASE WHEN a.active = 0 THEN 0 ELSE
				CASE WHEN b.payment_status = 'Refund Pending' THEN 2 ELSE 1 END END as active
	FROM
	(	SELECT	f.house_id,
				f.seat_number,
				f.row_number,
				f.active,
				g.showing_id
		FROM	Houses_Rows f,
				Showings g
		WHERE	f.house_id = g.house_id AND
				@showing_id IN (NULL, g.showing_id)
	) a
	LEFT JOIN
	(	SELECT	q.row_number,
				q.seat_number,
				q.booking_id,
				r.payment_status,
				q.showing_id
		FROM	Booked_Seats q,
				Bookings r
		WHERE	@showing_id IN (NULL, q.showing_id) AND
				q.booking_id = r.booking_id AND
				r.payment_status NOT IN ('Payment Cancel', 'Refund Accepted', 'Payment Timeout')
	) b
	ON		a.row_number = b.row_number AND
			a.seat_number = b.seat_number AND
			a.showing_id = b.showing_id
	WHERE	@booking_id IN (NULL, b.booking_id) AND
			@row_num IN (NULL, a.row_number) AND
			@seat_num IN (NULL, a.seat_number)
END
GO
/****** Object:  StoredProcedure [dbo].[show_HouseSeat]    Script Date: 05/02/2013 15:56:49 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_HouseSeat]
	@house_id int = NULL
AS
BEGIN
	SELECT	*
	FROM	Houses_Rows
	WHERE	@house_id IN (NULL, house_id)
	ORDER BY
			house_id, row_number, seat_number
END
GO
/****** Object:  StoredProcedure [dbo].[insert_User]    Script Date: 05/02/2013 15:56:48 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[insert_User]
	@role varchar(30),
	@login_id varchar(50),
	@login_pw varchar(50),
	@user_name nvarchar(50) = NULL,
	@user_phone varchar(20),
	@user_email varchar(50)
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	DECLARE @id int
	SET @id = (	SELECT	MAX(account_id)
				FROM	Membership )
	SET @id = @id + 1
	SET IDENTITY_INSERT Membership ON
	SET NOCOUNT ON
	------------------------------
	INSERT
	INTO	Membership
			(account_id, login_id, login_pw, role)
	VALUES	(@id, @login_id, @login_pw, @role)
	SET @row = @row + @@rowcount

	INSERT
	INTO	Personal_Info
			(account_id, user_name, user_phone, user_email)
	VALUES	(@id, @user_name, @user_phone, @user_email)
	SET @row = @row + @@rowcount
	------------------------------
	SET IDENTITY_INSERT Membership OFF
	SET NOCOUNT OFF

	IF @row = 2
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[update_User]    Script Date: 05/02/2013 15:56:53 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[update_User]
	@account_id int,
	@login_pw varchar(50) = NULL,
	@user_name nvarchar(50) = NULL,
	@user_phone varchar(20) = NULL,
	@user_email varchar(50) = NULL
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	SET NOCOUNT ON
	UPDATE	Membership
	SET		login_pw = CASE WHEN @login_pw IS NULL THEN login_pw ELSE @login_pw END
	WHERE	account_id = @account_id
	SET @row = @row + @@rowcount
	--------------------------------------
	UPDATE	Personal_Info
	SET		user_name = CASE WHEN @user_name IS NULL THEN user_name ELSE @user_name END,
			user_phone = CASE WHEN @user_phone IS NULL THEN user_phone ELSE @user_phone END,
			user_email = CASE WHEN @user_email IS NULL THEN user_email ELSE @user_email END
	WHERE	@account_id = account_id
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 2
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[show_User]    Script Date: 05/02/2013 15:56:51 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_User]
	@account_id int = NULL,
	@role varchar(50) = NULL,
	@login_id varchar(50) = NULL,
	@login_pw varchar(50) = NULL,
	@user_name nvarchar(50)= NULL,
	@user_phone varchar(20) = NULL,
	@user_email varchar(50) = NULL
AS
BEGIN
	SELECT	a.account_id as account_id,
			a.role as role,
			a.login_id as login_id,
			a.login_pw as login_pw,
			b.user_name as user_name,
			b.user_phone as user_phone,
			b.user_email as user_email
	FROM	Membership a,
			Personal_Info b
	WHERE	a.account_id = b.account_id AND
			@account_id IN (a.account_id, NULL) AND
			@role IN (a.role, NULL) AND
			@login_id IN (a.login_id, NULL) AND
			@login_pw IN (a.login_pw, NULL) AND
			@user_name IN (b.user_name, NULL) AND
			@user_phone IN (b.user_phone, NULL) AND
			@user_email IN (b.user_email, NULL) AND
			a.role NOT IN ('Deleted')
	ORDER BY
			CASE a.role
				WHEN 'Manager' THEN 0
				WHEN 'Officer' THEN 1
				WHEN 'Member' THEN 2
				WHEN 'Guest' THEN 3
			END,
			login_id, user_name
END
GO
/****** Object:  StoredProcedure [dbo].[delete_Booking_Hard]    Script Date: 05/02/2013 15:56:45 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[delete_Booking_Hard]
	@booking_id int
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	SET NOCOUNT ON
	DELETE
	FROM	Bookings
	WHERE	@booking_id = booking_id
	SET @row = @row + @@rowcount

	DELETE
	FROM	Booked_Seats
	WHERE	@booking_id = booking_id
	SET @row = @row + @@rowcount

	DELETE
	FROM	Ticket_Queue
	WHERE	@booking_id = booking_id
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	RETURN 0
END
GO
/****** Object:  StoredProcedure [dbo].[show_SeatQueue]    Script Date: 05/02/2013 15:56:50 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_SeatQueue]
	@showing_id int,
	@row_number int,
	@seat_number int
AS
BEGIN
	SELECT	a.showing_id,
			a.row_number,
			a.seat_number,
			a.booking_id,
			b.payment_status
	FROM	Booked_Seats a,
			Bookings b
	WHERE	a.booking_id = b.booking_id AND
			@showing_id = a.showing_id AND
			@row_number = a.row_number AND
			@seat_number = a.seat_number AND
			b.payment_status = 'Refund Pending'
	ORDER BY
			a.booking_id
END
GO
/****** Object:  StoredProcedure [dbo].[insert_ShowingSeat]    Script Date: 05/02/2013 15:56:48 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[insert_ShowingSeat]
	@showing_id int,
	@row_number int,
	@seat_number int,
	@booking_id int
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	SET NOCOUNT ON
	INSERT
	INTO	Booked_Seats
			(showing_id, row_number, seat_number, booking_id)
	VALUES	(@showing_id, @row_number, @seat_number, @booking_id)
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[delete_User]    Script Date: 05/02/2013 15:56:46 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[delete_User]
	@account_id int
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	SET NOCOUNT ON
	UPDATE	Membership
	SET		role = 'Deleted'
	WHERE	@account_id = account_id
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[update_Movie]    Script Date: 05/02/2013 15:56:53 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[update_Movie]
	@lang varchar(3),
	@movie_id int,
	@name nvarchar(255) = NULL,
	@author nvarchar(50) = NULL,
	@desc nvarchar(255) = NULL,
	@duration int = NULL,
	@start datetime = NULL,
	@end datetime = NULL
AS
BEGIN
	SET NOCOUNT ON
	DECLARE @row int
	SET @row = 0
	
	DECLARE @langc varchar(3)
	SET @langc = (	SELECT	language_code
					FROM	Ref_Language
					WHERE	@lang = language )
	--------------------------------------
	UPDATE	Movies
	SET		movie_duration = CASE WHEN @duration IS NULL THEN movie_duration ELSE @duration END,
			movie_startDate = CASE WHEN @start IS NULL THEN movie_startDate ELSE @start END,
			movie_endDate = CASE WHEN @end IS NULL THEN movie_endDate ELSE @end END
	WHERE	movie_id = @movie_id
	SET @row = @row + @@rowcount
	--------------------------------------
	UPDATE	Movies_Name
	SET		movie_name = CASE WHEN @name IS NULL THEN movie_name ELSE @name END
	WHERE	movie_id = @movie_id AND
			language_code = @lang
	SET @row = @row + @@rowcount
	--------------------------------------
	UPDATE	Movies_Author
	SET		movie_author = CASE WHEN @author IS NULL THEN movie_author ELSE @author END
	WHERE	movie_id = @movie_id AND
			language_code = @lang
	SET @row = @row + @@rowcount
	--------------------------------------
	UPDATE	Movies_Description
	SET		movie_description = CASE WHEN @desc IS NULL THEN movie_description ELSE @desc END
	WHERE	movie_id = @movie_id AND
			language_code = @lang
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 4
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[show_Movie]    Script Date: 05/02/2013 15:56:50 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[show_Movie]
	@lang varchar(3) = NULL,
	@id int = NULL,
	@name nvarchar(50) = NULL,
	@author nvarchar(50) = NULL,
	@sort varchar(50) = NULL
AS
BEGIN
	IF @lang IS NULL
		SET @lang = 'en'
	DECLARE @lang2 varchar(3)
	-------------------------------
	IF @sort IS NULL
		SET @sort = 'movie_startDate'
	DECLARE @language varchar(50)
	SET @language = (	SELECT	language
						FROM	Ref_Language
						WHERE	language_code = @lang )
	DECLARE @now datetime
	SET @now = getdate()


	SELECT	b.language_code as language,
			a.movie_id as movie_id,
			b.movie_name as movie_name,
			c.movie_author as movie_author,
			d.movie_description as movie_description,
			a.movie_duration as movie_duration,
			convert(varchar, a.movie_startDate, 102) as movie_startDate,
			convert(varchar, a.movie_endDate, 102) as movie_endDate
	FROM	Movies a,
			Movies_Name b,
			Movies_Author c,
			Movies_Description d
	WHERE	a.movie_id = b.movie_id AND
			a.movie_id = c.movie_id AND
			a.movie_id = d.movie_id AND
			b.language_code = c.language_code AND
			b.language_code = d.language_code AND
			b.language_code = @lang AND
			@id IN (a.movie_id, NULL) AND
			a.active = 1 AND
			@now <= movie_endDate AND
			a.movie_id IN
			(	SELECT	a.movie_id
				FROM	Movies a,
						Movies_Name b,
						Movies_Author c,
						Movies_Description d
				WHERE	a.movie_id = b.movie_id AND
						a.movie_id = c.movie_id AND
						a.movie_id = d.movie_id AND
						b.language_code = c.language_code AND
						b.language_code = d.language_code AND
						(@name IS NULL OR b.movie_name LIKE '%'+@name+'%') AND
						(@author IS NULL OR c.movie_author LIKE '%'+@author+'%')
			)
	ORDER BY
			CASE WHEN @sort = 'movie_id' THEN a.movie_id END,
			CASE WHEN @sort = 'movie_name' THEN movie_name END,
			CASE WHEN @sort = 'movie_author' THEN movie_author END,
			CASE WHEN @sort = 'movie_description' THEN movie_description END,
			CASE WHEN @sort = 'movie_duration' THEN movie_duration END,
			CASE WHEN @sort = 'movie_startDate' THEN movie_startDate END,
			CASE WHEN @sort = 'movie_endDate' THEN movie_endDate END,
			a.movie_id
END
GO
/****** Object:  StoredProcedure [dbo].[insert_Movie]    Script Date: 05/02/2013 15:56:47 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[insert_Movie]
	@name		nvarchar(255),
	@author		nvarchar(50),
	@desc		nvarchar(255) = NULL,
	@start		datetime = NULL,
	@end		datetime = NULL,
	@duration	int = NULL
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	IF @end IS NULL
		SET @end = dateadd(day,30,getdate())
	IF @start IS NULL
		SET @start = getdate()
	IF @duration IS NULL
		SET @duration = 60
	DECLARE @lang varchar(3)
	SET @lang = 'en'
	DECLARE @id int
	SET @id = (	SELECT	MAX(movie_id)
				FROM	Movies )
	SET @id = @id + 1
	DECLARE @c int --loop counter
	SET @c = 2

	SET IDENTITY_INSERT Movies ON
	SET NOCOUNT ON
	------------------------------
	WHILE @c > 0
	BEGIN
		IF @c = 2
		BEGIN
			INSERT
			INTO	Movies
					(movie_id, movie_duration, movie_startDate, movie_endDate)
			VALUES	(@id, @duration, @start, @end)
			SET @row = @row + @@rowcount
		END
		INSERT
		INTO	Movies_Author
				(movie_id, language_code, movie_author)
		VALUES	(@id, @lang, @author)
		SET @row = @row + @@rowcount
		INSERT
		INTO	Movies_Description
				(movie_id, language_code, movie_description)
		VALUES	(@id, @lang, @desc)
		SET @row = @row + @@rowcount
		INSERT
		INTO	Movies_Name
				(movie_id, language_code, movie_name)
		VALUES	(@id, @lang, @name)
		SET @row = @row + @@rowcount

		SET @lang = 'zh'
		SET @c = @c - 1
	END
	-------------------------------
	SET IDENTITY_INSERT Movies OFF
	SET NOCOUNT OFF

	IF @row = 7
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[insert_SeatQueue]    Script Date: 05/02/2013 15:56:47 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[insert_SeatQueue]
	@showing_id int,
	@row_number int,
	@seat_number int,
	@booking_id int
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	SET NOCOUNT ON
	INSERT
	INTO	Ticket_Queue
			(showing_id, row_number, seat_number, booking_id)
	VALUES	(@showing_id, @row_number, @seat_number, @booking_id)
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[delete_SeatQueue]    Script Date: 05/02/2013 15:56:46 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[delete_SeatQueue]
	@booking_id int
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	SET NOCOUNT ON
	DELETE
	FROM	Ticket_Queue
	WHERE	@booking_id = booking_id
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[update_BookingStatus]    Script Date: 05/02/2013 15:56:52 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[update_BookingStatus]
	@booking_id int,
	@status varchar(50),
	@account_id int = NULL,
	@guest_email varchar(50) = null
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	SET NOCOUNT ON
	UPDATE	Bookings
	SET		payment_status = @status,
			account_id = CASE WHEN @account_id IS NULL THEN account_id ELSE @account_id END,
			guest_email = @guest_email
	WHERE	@booking_id = booking_id
	SET @row = @row + @@rowcount
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  StoredProcedure [dbo].[insert_Booking]    Script Date: 05/02/2013 15:56:47 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[insert_Booking]
	@account_id int = NULL,
	@guest_email varchar(50) = NULL
AS
BEGIN
	DECLARE @id int
	SET @id = (	SELECT	MAX(booking_id)
				FROM	Bookings )
	SET @id = @id + 1

	IF @account_id IS NULL
	BEGIN
		IF @guest_email IS NOT NULL
			SET @account_id = 0
	END

	SET NOCOUNT ON
	SET IDENTITY_INSERT Bookings ON
	---------------------------
	INSERT
	INTO	Bookings
			(booking_id, account_id, guest_email)
	VALUES	(@id, @account_id, @guest_email)
	---------------------------
	SET IDENTITY_INSERT Bookings OFF
	SET NOCOUNT OFF

	RETURN @id
END
GO
/****** Object:  StoredProcedure [dbo].[searchPhoneRecord]    Script Date: 05/02/2013 15:56:48 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE PROCEDURE [dbo].[searchPhoneRecord]
       @name VARCHAR(255)
AS
BEGIN
       SELECT [Name], [Phone] FROM [phonebook]
       WHERE [Name] = @name
END
GO
/****** Object:  StoredProcedure [dbo].[delete_Movie]    Script Date: 05/02/2013 15:56:46 ******/
SET ANSI_NULLS OFF
GO
SET QUOTED_IDENTIFIER OFF
GO
CREATE procedure [dbo].[delete_Movie]
	@movie_id int
AS
BEGIN
	DECLARE @row int
	SET @row = 0

	SET NOCOUNT ON
	------------------------------
	UPDATE	Movies
	SET		active = 0
	WHERE	@movie_id = movie_id
	SET @row = @row + @@rowcount
	-------------------------------
	SET NOCOUNT OFF

	IF @row = 1
		RETURN 0
	ELSE
		RETURN -1
END
GO
/****** Object:  Check [CK__membershi__login__32767D0B]    Script Date: 05/02/2013 15:56:57 ******/
ALTER TABLE [dbo].[Membership]  WITH NOCHECK ADD  CONSTRAINT [CK__membershi__login__32767D0B] CHECK  ((case when (((not([login_id] like '%[^0-9a-zA-Z-_]%')))) then 1 else 0 end = 1))
GO
ALTER TABLE [dbo].[Membership] CHECK CONSTRAINT [CK__membershi__login__32767D0B]
GO
/****** Object:  Check [CK__personal___user___607251E5]    Script Date: 05/02/2013 15:57:02 ******/
ALTER TABLE [dbo].[Personal_Info]  WITH NOCHECK ADD  CONSTRAINT [CK__personal___user___607251E5] CHECK  (([user_phone] is null or isnumeric([user_phone]) = 1))
GO
ALTER TABLE [dbo].[Personal_Info] CHECK CONSTRAINT [CK__personal___user___607251E5]
GO
/****** Object:  ForeignKey [FK__booked_se__booki__4E1E9780]    Script Date: 05/02/2013 15:56:54 ******/
ALTER TABLE [dbo].[Booked_Seats]  WITH NOCHECK ADD  CONSTRAINT [FK__booked_se__booki__4E1E9780] FOREIGN KEY([booking_id])
REFERENCES [dbo].[Bookings] ([booking_id])
GO
ALTER TABLE [dbo].[Booked_Seats] CHECK CONSTRAINT [FK__booked_se__booki__4E1E9780]
GO
/****** Object:  ForeignKey [FK__bookings__accoun__6E01572D]    Script Date: 05/02/2013 15:56:55 ******/
ALTER TABLE [dbo].[Bookings]  WITH NOCHECK ADD  CONSTRAINT [FK__bookings__accoun__6E01572D] FOREIGN KEY([account_id])
REFERENCES [dbo].[Membership] ([account_id])
GO
ALTER TABLE [dbo].[Bookings] CHECK CONSTRAINT [FK__bookings__accoun__6E01572D]
GO
/****** Object:  ForeignKey [FK__bookings__refund__12FDD1B2]    Script Date: 05/02/2013 15:56:55 ******/
ALTER TABLE [dbo].[Bookings]  WITH NOCHECK ADD  CONSTRAINT [FK__bookings__refund__12FDD1B2] FOREIGN KEY([payment_status])
REFERENCES [dbo].[Ref_Payment_Status] ([payment_status])
GO
ALTER TABLE [dbo].[Bookings] CHECK CONSTRAINT [FK__bookings__refund__12FDD1B2]
GO
/****** Object:  ForeignKey [FK__houses_ro__house__25518C17]    Script Date: 05/02/2013 15:56:56 ******/
ALTER TABLE [dbo].[Houses_Rows]  WITH CHECK ADD  CONSTRAINT [FK__houses_ro__house__25518C17] FOREIGN KEY([house_id])
REFERENCES [dbo].[Houses] ([house_id])
GO
ALTER TABLE [dbo].[Houses_Rows] CHECK CONSTRAINT [FK__houses_ro__house__25518C17]
GO
/****** Object:  ForeignKey [FK__membership__role__6FE99F9F]    Script Date: 05/02/2013 15:56:57 ******/
ALTER TABLE [dbo].[Membership]  WITH NOCHECK ADD  CONSTRAINT [FK__membership__role__6FE99F9F] FOREIGN KEY([role])
REFERENCES [dbo].[Ref_Role] ([role])
GO
ALTER TABLE [dbo].[Membership] CHECK CONSTRAINT [FK__membership__role__6FE99F9F]
GO
/****** Object:  ForeignKey [FK__movies_au__langu__73BA3083]    Script Date: 05/02/2013 15:56:59 ******/
ALTER TABLE [dbo].[Movies_Author]  WITH NOCHECK ADD  CONSTRAINT [FK__movies_au__langu__73BA3083] FOREIGN KEY([language_code])
REFERENCES [dbo].[Ref_Language] ([language_code])
GO
ALTER TABLE [dbo].[Movies_Author] CHECK CONSTRAINT [FK__movies_au__langu__73BA3083]
GO
/****** Object:  ForeignKey [FK__movies_au__movie__72C60C4A]    Script Date: 05/02/2013 15:56:59 ******/
ALTER TABLE [dbo].[Movies_Author]  WITH NOCHECK ADD  CONSTRAINT [FK__movies_au__movie__72C60C4A] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movies] ([movie_id])
GO
ALTER TABLE [dbo].[Movies_Author] CHECK CONSTRAINT [FK__movies_au__movie__72C60C4A]
GO
/****** Object:  ForeignKey [FK__movies_de__langu__4BAC3F29]    Script Date: 05/02/2013 15:57:00 ******/
ALTER TABLE [dbo].[Movies_Description]  WITH NOCHECK ADD  CONSTRAINT [FK__movies_de__langu__4BAC3F29] FOREIGN KEY([language_code])
REFERENCES [dbo].[Ref_Language] ([language_code])
GO
ALTER TABLE [dbo].[Movies_Description] CHECK CONSTRAINT [FK__movies_de__langu__4BAC3F29]
GO
/****** Object:  ForeignKey [FK__movies_de__movie__4AB81AF0]    Script Date: 05/02/2013 15:57:00 ******/
ALTER TABLE [dbo].[Movies_Description]  WITH NOCHECK ADD  CONSTRAINT [FK__movies_de__movie__4AB81AF0] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movies] ([movie_id])
GO
ALTER TABLE [dbo].[Movies_Description] CHECK CONSTRAINT [FK__movies_de__movie__4AB81AF0]
GO
/****** Object:  ForeignKey [FK__movies_na__langu__4D94879B]    Script Date: 05/02/2013 15:57:01 ******/
ALTER TABLE [dbo].[Movies_Name]  WITH NOCHECK ADD  CONSTRAINT [FK__movies_na__langu__4D94879B] FOREIGN KEY([language_code])
REFERENCES [dbo].[Ref_Language] ([language_code])
GO
ALTER TABLE [dbo].[Movies_Name] CHECK CONSTRAINT [FK__movies_na__langu__4D94879B]
GO
/****** Object:  ForeignKey [FK__movies_na__movie__4CA06362]    Script Date: 05/02/2013 15:57:01 ******/
ALTER TABLE [dbo].[Movies_Name]  WITH NOCHECK ADD  CONSTRAINT [FK__movies_na__movie__4CA06362] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movies] ([movie_id])
GO
ALTER TABLE [dbo].[Movies_Name] CHECK CONSTRAINT [FK__movies_na__movie__4CA06362]
GO
/****** Object:  ForeignKey [FK__personal___accou__6EF57B66]    Script Date: 05/02/2013 15:57:02 ******/
ALTER TABLE [dbo].[Personal_Info]  WITH NOCHECK ADD  CONSTRAINT [FK__personal___accou__6EF57B66] FOREIGN KEY([account_id])
REFERENCES [dbo].[Membership] ([account_id])
GO
ALTER TABLE [dbo].[Personal_Info] CHECK CONSTRAINT [FK__personal___accou__6EF57B66]
GO
/****** Object:  ForeignKey [FK__showings__house___3B75D760]    Script Date: 05/02/2013 15:57:04 ******/
ALTER TABLE [dbo].[Showings]  WITH CHECK ADD  CONSTRAINT [FK__showings__house___3B75D760] FOREIGN KEY([house_id])
REFERENCES [dbo].[Houses] ([house_id])
GO
ALTER TABLE [dbo].[Showings] CHECK CONSTRAINT [FK__showings__house___3B75D760]
GO
/****** Object:  ForeignKey [FK__showings__movie___3C69FB99]    Script Date: 05/02/2013 15:57:04 ******/
ALTER TABLE [dbo].[Showings]  WITH NOCHECK ADD  CONSTRAINT [FK__showings__movie___3C69FB99] FOREIGN KEY([movie_id])
REFERENCES [dbo].[Movies] ([movie_id])
GO
ALTER TABLE [dbo].[Showings] CHECK CONSTRAINT [FK__showings__movie___3C69FB99]
GO
