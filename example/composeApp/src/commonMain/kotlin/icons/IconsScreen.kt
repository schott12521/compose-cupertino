/*
 * Copyright (c) 2023-2024. Compose Cupertino project and open source contributors.
 * Copyright (c) 2025. Scott Lanoue.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package icons

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.slapps.cupertino.CupertinoAlertDialog
import com.slapps.cupertino.CupertinoIcon
import com.slapps.cupertino.CupertinoIconButton
import com.slapps.cupertino.CupertinoNavigateBackButton
import com.slapps.cupertino.CupertinoScaffold
import com.slapps.cupertino.CupertinoSegmentedControl
import com.slapps.cupertino.CupertinoSegmentedControlTab
import com.slapps.cupertino.CupertinoText
import com.slapps.cupertino.CupertinoTopAppBar
import com.slapps.cupertino.ExperimentalCupertinoApi
import com.slapps.cupertino.adaptive.AdaptiveWidget
import com.slapps.cupertino.default
import com.slapps.cupertino.icons.CupertinoIcons
import com.slapps.cupertino.icons.filled.Airtag
import com.slapps.cupertino.icons.filled.Alarm
import com.slapps.cupertino.icons.filled.Appletv
import com.slapps.cupertino.icons.filled.Archivebox
import com.slapps.cupertino.icons.filled.ArrowClockwiseCircle
import com.slapps.cupertino.icons.filled.ArrowCounterclockwiseCircle
import com.slapps.cupertino.icons.filled.ArrowCounterclockwiseIcloud
import com.slapps.cupertino.icons.filled.ArrowDownCircle
import com.slapps.cupertino.icons.filled.ArrowDownDoc
import com.slapps.cupertino.icons.filled.ArrowTriangle2CirclepathCamera
import com.slapps.cupertino.icons.filled.ArrowTriangle2CirclepathCircle
import com.slapps.cupertino.icons.filled.ArrowTurnUpForwardIphone
import com.slapps.cupertino.icons.filled.ArrowUpDoc
import com.slapps.cupertino.icons.filled.ArrowshapeTurnUpLeft
import com.slapps.cupertino.icons.filled.ArrowshapeTurnUpLeft2
import com.slapps.cupertino.icons.filled.Backward
import com.slapps.cupertino.icons.filled.BackwardEnd
import com.slapps.cupertino.icons.filled.Bag
import com.slapps.cupertino.icons.filled.BagBadgeMinus
import com.slapps.cupertino.icons.filled.BagBadgePlus
import com.slapps.cupertino.icons.filled.Balloon
import com.slapps.cupertino.icons.filled.Bandage
import com.slapps.cupertino.icons.filled.Banknote
import com.slapps.cupertino.icons.filled.Baseball
import com.slapps.cupertino.icons.filled.Basket
import com.slapps.cupertino.icons.filled.Basketball
import com.slapps.cupertino.icons.filled.BedDouble
import com.slapps.cupertino.icons.filled.Bell
import com.slapps.cupertino.icons.filled.BellAndWavesLeftAndRight
import com.slapps.cupertino.icons.filled.BellBadge
import com.slapps.cupertino.icons.filled.BellCircle
import com.slapps.cupertino.icons.filled.BellSlash
import com.slapps.cupertino.icons.filled.Binoculars
import com.slapps.cupertino.icons.filled.BirthdayCake
import com.slapps.cupertino.icons.filled.Bolt
import com.slapps.cupertino.icons.filled.BoltHorizontal
import com.slapps.cupertino.icons.filled.BoltSlash
import com.slapps.cupertino.icons.filled.Book
import com.slapps.cupertino.icons.filled.BookCircle
import com.slapps.cupertino.icons.filled.BookClosed
import com.slapps.cupertino.icons.filled.Bookmark
import com.slapps.cupertino.icons.filled.BookmarkSlash
import com.slapps.cupertino.icons.filled.Briefcase
import com.slapps.cupertino.icons.filled.BubbleLeft
import com.slapps.cupertino.icons.filled.BubbleRight
import com.slapps.cupertino.icons.filled.Building
import com.slapps.cupertino.icons.filled.Building2
import com.slapps.cupertino.icons.filled.Burst
import com.slapps.cupertino.icons.filled.Camera
import com.slapps.cupertino.icons.filled.CameraCircle
import com.slapps.cupertino.icons.filled.Capslock
import com.slapps.cupertino.icons.filled.Car
import com.slapps.cupertino.icons.filled.Cart
import com.slapps.cupertino.icons.filled.CartBadgeMinus
import com.slapps.cupertino.icons.filled.CartBadgePlus
import com.slapps.cupertino.icons.filled.Case
import com.slapps.cupertino.icons.filled.ChartBar
import com.slapps.cupertino.icons.filled.CheckmarkCircle
import com.slapps.cupertino.icons.filled.CheckmarkIcloud
import com.slapps.cupertino.icons.filled.CheckmarkMessage
import com.slapps.cupertino.icons.filled.CheckmarkSeal
import com.slapps.cupertino.icons.filled.CheckmarkShield
import com.slapps.cupertino.icons.filled.CheckmarkSquare
import com.slapps.cupertino.icons.filled.CircleLefthalfed
import com.slapps.cupertino.icons.filled.CircleRighthalfed
import com.slapps.cupertino.icons.filled.Clear
import com.slapps.cupertino.icons.filled.Clipboard
import com.slapps.cupertino.icons.filled.Clock
import com.slapps.cupertino.icons.filled.Cloud
import com.slapps.cupertino.icons.filled.Cone
import com.slapps.cupertino.icons.filled.Cpu
import com.slapps.cupertino.icons.filled.Creditcard
import com.slapps.cupertino.icons.filled.Cross
import com.slapps.cupertino.icons.filled.CrossCircle
import com.slapps.cupertino.icons.filled.CrossVial
import com.slapps.cupertino.icons.filled.Crown
import com.slapps.cupertino.icons.filled.Cube
import com.slapps.cupertino.icons.filled.CupAndSaucer
import com.slapps.cupertino.icons.filled.DeleteLeft
import com.slapps.cupertino.icons.filled.DeleteRight
import com.slapps.cupertino.icons.filled.Dice
import com.slapps.cupertino.icons.filled.Doc
import com.slapps.cupertino.icons.filled.DocBadgeArrowUp
import com.slapps.cupertino.icons.filled.DocBadgePlus
import com.slapps.cupertino.icons.filled.DocOnDoc
import com.slapps.cupertino.icons.filled.DocPlaintext
import com.slapps.cupertino.icons.filled.DocText
import com.slapps.cupertino.icons.filled.Drop
import com.slapps.cupertino.icons.filled.Ear
import com.slapps.cupertino.icons.filled.EllipsisBubble
import com.slapps.cupertino.icons.filled.EllipsisCircle
import com.slapps.cupertino.icons.filled.EllipsisMessage
import com.slapps.cupertino.icons.filled.Envelope
import com.slapps.cupertino.icons.filled.EnvelopeBadge
import com.slapps.cupertino.icons.filled.EnvelopeCircle
import com.slapps.cupertino.icons.filled.EnvelopeOpen
import com.slapps.cupertino.icons.filled.Eraser
import com.slapps.cupertino.icons.filled.ExclamationmarkCircle
import com.slapps.cupertino.icons.filled.ExclamationmarkIcloud
import com.slapps.cupertino.icons.filled.ExclamationmarkSquare
import com.slapps.cupertino.icons.filled.ExclamationmarkTriangle
import com.slapps.cupertino.icons.filled.Externaldrive
import com.slapps.cupertino.icons.filled.Eye
import com.slapps.cupertino.icons.filled.EyeSlash
import com.slapps.cupertino.icons.filled.Facemask
import com.slapps.cupertino.icons.filled.Fanblades
import com.slapps.cupertino.icons.filled.FanbladesSlash
import com.slapps.cupertino.icons.filled.Film
import com.slapps.cupertino.icons.filled.Flag
import com.slapps.cupertino.icons.filled.Flag2Crossed
import com.slapps.cupertino.icons.filled.FlagSlash
import com.slapps.cupertino.icons.filled.Flame
import com.slapps.cupertino.icons.filled.Folder
import com.slapps.cupertino.icons.filled.FolderBadgePlus
import com.slapps.cupertino.icons.filled.Football
import com.slapps.cupertino.icons.filled.ForkKnifeCircle
import com.slapps.cupertino.icons.filled.Forward
import com.slapps.cupertino.icons.filled.ForwardEnd
import com.slapps.cupertino.icons.filled.Fuelpump
import com.slapps.cupertino.icons.filled.Gamecontroller
import com.slapps.cupertino.icons.filled.Gearshape
import com.slapps.cupertino.icons.filled.Gearshape2
import com.slapps.cupertino.icons.filled.Gift
import com.slapps.cupertino.icons.filled.Giftcard
import com.slapps.cupertino.icons.filled.GlobeDesk
import com.slapps.cupertino.icons.filled.Graduationcap
import com.slapps.cupertino.icons.filled.Hammer
import com.slapps.cupertino.icons.filled.HandDraw
import com.slapps.cupertino.icons.filled.HandPointUp
import com.slapps.cupertino.icons.filled.HandPointUpLeft
import com.slapps.cupertino.icons.filled.HandRaised
import com.slapps.cupertino.icons.filled.HandRaisedSlash
import com.slapps.cupertino.icons.filled.HandTap
import com.slapps.cupertino.icons.filled.HandThumbsdown
import com.slapps.cupertino.icons.filled.HandThumbsup
import com.slapps.cupertino.icons.filled.HandWave
import com.slapps.cupertino.icons.filled.HandsSparkles
import com.slapps.cupertino.icons.filled.HeadphonesCircle
import com.slapps.cupertino.icons.filled.Heart
import com.slapps.cupertino.icons.filled.HeartCircle
import com.slapps.cupertino.icons.filled.HeartSlash
import com.slapps.cupertino.icons.filled.HeartTextSquare
import com.slapps.cupertino.icons.filled.Hifispeaker
import com.slapps.cupertino.icons.filled.Homepod
import com.slapps.cupertino.icons.filled.Homepodmini
import com.slapps.cupertino.icons.filled.House
import com.slapps.cupertino.icons.filled.Icloud
import com.slapps.cupertino.icons.filled.IcloudAndArrowDown
import com.slapps.cupertino.icons.filled.IcloudAndArrowUp
import com.slapps.cupertino.icons.filled.InfoBubble
import com.slapps.cupertino.icons.filled.InfoCircle
import com.slapps.cupertino.icons.filled.InfoSquare
import com.slapps.cupertino.icons.filled.Key
import com.slapps.cupertino.icons.filled.KeyIcloud
import com.slapps.cupertino.icons.filled.Keyboard
import com.slapps.cupertino.icons.filled.Lanyardcard
import com.slapps.cupertino.icons.filled.Leaf
import com.slapps.cupertino.icons.filled.Level
import com.slapps.cupertino.icons.filled.Lifepreserver
import com.slapps.cupertino.icons.filled.LightBeaconMax
import com.slapps.cupertino.icons.filled.Lightbulb
import com.slapps.cupertino.icons.filled.LightbulbSlash
import com.slapps.cupertino.icons.filled.LinkCircle
import com.slapps.cupertino.icons.filled.ListBulletCircle
import com.slapps.cupertino.icons.filled.ListBulletClipboard
import com.slapps.cupertino.icons.filled.ListClipboard
import com.slapps.cupertino.icons.filled.Location
import com.slapps.cupertino.icons.filled.Lock
import com.slapps.cupertino.icons.filled.LockCircle
import com.slapps.cupertino.icons.filled.LockOpen
import com.slapps.cupertino.icons.filled.LockSlash
import com.slapps.cupertino.icons.filled.Magazine
import com.slapps.cupertino.icons.filled.Mail
import com.slapps.cupertino.icons.filled.MailStack
import com.slapps.cupertino.icons.filled.Map
import com.slapps.cupertino.icons.filled.Medal
import com.slapps.cupertino.icons.filled.Megaphone
import com.slapps.cupertino.icons.filled.Menucard
import com.slapps.cupertino.icons.filled.Message
import com.slapps.cupertino.icons.filled.MessageBadgeed
import com.slapps.cupertino.icons.filled.Mic
import com.slapps.cupertino.icons.filled.MicSlash
import com.slapps.cupertino.icons.filled.MinusCircle
import com.slapps.cupertino.icons.filled.Moon
import com.slapps.cupertino.icons.filled.MoonStars
import com.slapps.cupertino.icons.filled.Mount
import com.slapps.cupertino.icons.filled.Newspaper
import com.slapps.cupertino.icons.filled.Opticaldisc
import com.slapps.cupertino.icons.filled.Paintbrush
import com.slapps.cupertino.icons.filled.PaintbrushPointed
import com.slapps.cupertino.icons.filled.Paintpalette
import com.slapps.cupertino.icons.filled.PaperclipCircle
import com.slapps.cupertino.icons.filled.Paperplane
import com.slapps.cupertino.icons.filled.PartyPopper
import com.slapps.cupertino.icons.filled.Pause
import com.slapps.cupertino.icons.filled.PauseCircle
import com.slapps.cupertino.icons.filled.Pawprint
import com.slapps.cupertino.icons.filled.PencilCircle
import com.slapps.cupertino.icons.filled.Person
import com.slapps.cupertino.icons.filled.Person2
import com.slapps.cupertino.icons.filled.PersonCircle
import com.slapps.cupertino.icons.filled.PersonCropCircle
import com.slapps.cupertino.icons.filled.PersonCropCircleBadgeMinus
import com.slapps.cupertino.icons.filled.PersonCropCircleBadgePlus
import com.slapps.cupertino.icons.filled.PersonCropSquare
import com.slapps.cupertino.icons.filled.PersonIcloud
import com.slapps.cupertino.icons.filled.PersonTextRectangle
import com.slapps.cupertino.icons.filled.PersonViewfinder
import com.slapps.cupertino.icons.filled.PersonWave2
import com.slapps.cupertino.icons.filled.Phone
import com.slapps.cupertino.icons.filled.PhoneAndWaveform
import com.slapps.cupertino.icons.filled.PhoneArrowDownLeft
import com.slapps.cupertino.icons.filled.PhoneArrowUpRight
import com.slapps.cupertino.icons.filled.PhoneBadgePlus
import com.slapps.cupertino.icons.filled.PhoneCircle
import com.slapps.cupertino.icons.filled.PhoneConnection
import com.slapps.cupertino.icons.filled.Photo
import com.slapps.cupertino.icons.filled.PhotoStack
import com.slapps.cupertino.icons.filled.Pill
import com.slapps.cupertino.icons.filled.Pin
import com.slapps.cupertino.icons.filled.PinCircle
import com.slapps.cupertino.icons.filled.PinSlash
import com.slapps.cupertino.icons.filled.Pip
import com.slapps.cupertino.icons.filled.Play
import com.slapps.cupertino.icons.filled.PlayCircle
import com.slapps.cupertino.icons.filled.PlusApp
import com.slapps.cupertino.icons.filled.PlusBubble
import com.slapps.cupertino.icons.filled.PlusCircle
import com.slapps.cupertino.icons.filled.PlusMessage
import com.slapps.cupertino.icons.filled.PlusSquare
import com.slapps.cupertino.icons.filled.Popcorn
import com.slapps.cupertino.icons.filled.PowerCircle
import com.slapps.cupertino.icons.filled.Printer
import com.slapps.cupertino.icons.filled.Puzzlepiece
import com.slapps.cupertino.icons.filled.PuzzlepieceExtension
import com.slapps.cupertino.icons.filled.QuestionmarkApp
import com.slapps.cupertino.icons.filled.QuestionmarkCircle
import com.slapps.cupertino.icons.filled.QuestionmarkFolder
import com.slapps.cupertino.icons.filled.QuestionmarkSquare
import com.slapps.cupertino.icons.filled.RecordCircle
import com.slapps.cupertino.icons.filled.RectanglePortraitAndArrowForward
import com.slapps.cupertino.icons.filled.RectangleStack
import com.slapps.cupertino.icons.filled.RotateLeft
import com.slapps.cupertino.icons.filled.RotateRight
import com.slapps.cupertino.icons.filled.Ruler
import com.slapps.cupertino.icons.filled.Safari
import com.slapps.cupertino.icons.filled.Scalemass
import com.slapps.cupertino.icons.filled.Scroll
import com.slapps.cupertino.icons.filled.ShazamLogo
import com.slapps.cupertino.icons.filled.Shield
import com.slapps.cupertino.icons.filled.ShieldLefthalfed
import com.slapps.cupertino.icons.filled.ShieldRighthalfed
import com.slapps.cupertino.icons.filled.ShieldSlash
import com.slapps.cupertino.icons.filled.Shippingbox
import com.slapps.cupertino.icons.filled.Shoeprints
import com.slapps.cupertino.icons.filled.Simcard
import com.slapps.cupertino.icons.filled.SmallcircleedCircle
import com.slapps.cupertino.icons.filled.Speaker
import com.slapps.cupertino.icons.filled.SpeakerMinus
import com.slapps.cupertino.icons.filled.SpeakerPlus
import com.slapps.cupertino.icons.filled.SpeakerSlash
import com.slapps.cupertino.icons.filled.SpeakerWave2
import com.slapps.cupertino.icons.filled.SquareAndArrowUp
import com.slapps.cupertino.icons.filled.SquareBottomthirdInseted
import com.slapps.cupertino.icons.filled.SquareOnSquare
import com.slapps.cupertino.icons.filled.SquareSplit1x2
import com.slapps.cupertino.icons.filled.SquareSplit2x1
import com.slapps.cupertino.icons.filled.SquareStack
import com.slapps.cupertino.icons.filled.SquareStack3dUp
import com.slapps.cupertino.icons.filled.SquareTopthirdInseted
import com.slapps.cupertino.icons.filled.Star
import com.slapps.cupertino.icons.filled.StarLeadinghalfed
import com.slapps.cupertino.icons.filled.StarSlash
import com.slapps.cupertino.icons.filled.Staroflife
import com.slapps.cupertino.icons.filled.Stop
import com.slapps.cupertino.icons.filled.StopCircle
import com.slapps.cupertino.icons.filled.Suitcase
import com.slapps.cupertino.icons.filled.SunMax
import com.slapps.cupertino.icons.filled.Tag
import com.slapps.cupertino.icons.filled.Terminal
import com.slapps.cupertino.icons.filled.TextBubble
import com.slapps.cupertino.icons.filled.Theatermasks
import com.slapps.cupertino.icons.filled.Trash
import com.slapps.cupertino.icons.filled.TrashSlash
import com.slapps.cupertino.icons.filled.TrayAndArrowDown
import com.slapps.cupertino.icons.filled.TrayAndArrowUp
import com.slapps.cupertino.icons.filled.Trophy
import com.slapps.cupertino.icons.filled.Tshirt
import com.slapps.cupertino.icons.filled.Tv
import com.slapps.cupertino.icons.filled.TvAndHifispeaker
import com.slapps.cupertino.icons.filled.Umbrella
import com.slapps.cupertino.icons.filled.Video
import com.slapps.cupertino.icons.filled.VideoCircle
import com.slapps.cupertino.icons.filled.VideoSlash
import com.slapps.cupertino.icons.filled.Volleyball
import com.slapps.cupertino.icons.filled.WalletPass
import com.slapps.cupertino.icons.filled.WebCamera
import com.slapps.cupertino.icons.filled.WifiRouter
import com.slapps.cupertino.icons.filled.Wineglass
import com.slapps.cupertino.icons.filled.XmarkApp
import com.slapps.cupertino.icons.filled.XmarkBin
import com.slapps.cupertino.icons.filled.XmarkCircle
import com.slapps.cupertino.icons.filled.XmarkIcloud
import com.slapps.cupertino.icons.filled.XmarkSeal
import com.slapps.cupertino.icons.filled.XmarkShield
import com.slapps.cupertino.icons.filled._4kTv
import com.slapps.cupertino.icons.outlined.Airplane
import com.slapps.cupertino.icons.outlined.AirplaneArrival
import com.slapps.cupertino.icons.outlined.AirplaneDeparture
import com.slapps.cupertino.icons.outlined.Airplayaudio
import com.slapps.cupertino.icons.outlined.Airpods
import com.slapps.cupertino.icons.outlined.AirpodsGen3
import com.slapps.cupertino.icons.outlined.Airpodsmax
import com.slapps.cupertino.icons.outlined.Airpodspro
import com.slapps.cupertino.icons.outlined.Airtag
import com.slapps.cupertino.icons.outlined.Alarm
import com.slapps.cupertino.icons.outlined.Alt
import com.slapps.cupertino.icons.outlined.Angle
import com.slapps.cupertino.icons.outlined.AntennaRadiowavesLeftAndRight
import com.slapps.cupertino.icons.outlined.AntennaRadiowavesLeftAndRightSlash
import com.slapps.cupertino.icons.outlined.AppleLogo
import com.slapps.cupertino.icons.outlined.Applepencil
import com.slapps.cupertino.icons.outlined.Appletv
import com.slapps.cupertino.icons.outlined.Applewatch
import com.slapps.cupertino.icons.outlined.ApplewatchRadiowavesLeftAndRight
import com.slapps.cupertino.icons.outlined.ApplewatchWatchface
import com.slapps.cupertino.icons.outlined.Archivebox
import com.slapps.cupertino.icons.outlined.Arrow3Trianglepath
import com.slapps.cupertino.icons.outlined.ArrowClockwise
import com.slapps.cupertino.icons.outlined.ArrowCounterclockwise
import com.slapps.cupertino.icons.outlined.ArrowCounterclockwiseIcloud
import com.slapps.cupertino.icons.outlined.ArrowDown
import com.slapps.cupertino.icons.outlined.ArrowDownAndLineHorizontalAndArrowUp
import com.slapps.cupertino.icons.outlined.ArrowDownCircle
import com.slapps.cupertino.icons.outlined.ArrowDownDoc
import com.slapps.cupertino.icons.outlined.ArrowDownRightAndArrowUpLeft
import com.slapps.cupertino.icons.outlined.ArrowDownToLine
import com.slapps.cupertino.icons.outlined.ArrowLeftAndRight
import com.slapps.cupertino.icons.outlined.ArrowLeftArrowRight
import com.slapps.cupertino.icons.outlined.ArrowTriangle2Circlepath
import com.slapps.cupertino.icons.outlined.ArrowTriangle2CirclepathCamera
import com.slapps.cupertino.icons.outlined.ArrowTriangleBranch
import com.slapps.cupertino.icons.outlined.ArrowTurnDownLeft
import com.slapps.cupertino.icons.outlined.ArrowTurnDownRight
import com.slapps.cupertino.icons.outlined.ArrowTurnRightUp
import com.slapps.cupertino.icons.outlined.ArrowTurnUpForwardIphone
import com.slapps.cupertino.icons.outlined.ArrowTurnUpLeft
import com.slapps.cupertino.icons.outlined.ArrowTurnUpRight
import com.slapps.cupertino.icons.outlined.ArrowUpAndDown
import com.slapps.cupertino.icons.outlined.ArrowUpArrowDown
import com.slapps.cupertino.icons.outlined.ArrowUpDoc
import com.slapps.cupertino.icons.outlined.ArrowUpLeftAndArrowDownRight
import com.slapps.cupertino.icons.outlined.ArrowUturnLeft
import com.slapps.cupertino.icons.outlined.ArrowUturnRight
import com.slapps.cupertino.icons.outlined.ArrowshapeTurnUpLeft
import com.slapps.cupertino.icons.outlined.ArrowshapeTurnUpLeft2
import com.slapps.cupertino.icons.outlined.At
import com.slapps.cupertino.icons.outlined.Backward
import com.slapps.cupertino.icons.outlined.BackwardEnd
import com.slapps.cupertino.icons.outlined.Bag
import com.slapps.cupertino.icons.outlined.BagBadgeMinus
import com.slapps.cupertino.icons.outlined.BagBadgePlus
import com.slapps.cupertino.icons.outlined.Balloon
import com.slapps.cupertino.icons.outlined.Bandage
import com.slapps.cupertino.icons.outlined.Banknote
import com.slapps.cupertino.icons.outlined.Barcode
import com.slapps.cupertino.icons.outlined.BarcodeViewfinder
import com.slapps.cupertino.icons.outlined.Baseball
import com.slapps.cupertino.icons.outlined.Basket
import com.slapps.cupertino.icons.outlined.Basketball
import com.slapps.cupertino.icons.outlined.Battery100
import com.slapps.cupertino.icons.outlined.BedDouble
import com.slapps.cupertino.icons.outlined.Bell
import com.slapps.cupertino.icons.outlined.BellAndWavesLeftAndRight
import com.slapps.cupertino.icons.outlined.BellBadge
import com.slapps.cupertino.icons.outlined.BellCircle
import com.slapps.cupertino.icons.outlined.BellSlash
import com.slapps.cupertino.icons.outlined.Bicycle
import com.slapps.cupertino.icons.outlined.Binoculars
import com.slapps.cupertino.icons.outlined.BirthdayCake
import com.slapps.cupertino.icons.outlined.Bitcoinsign
import com.slapps.cupertino.icons.outlined.Bolt
import com.slapps.cupertino.icons.outlined.BoltHorizontal
import com.slapps.cupertino.icons.outlined.BoltSlash
import com.slapps.cupertino.icons.outlined.Book
import com.slapps.cupertino.icons.outlined.BookCircle
import com.slapps.cupertino.icons.outlined.BookClosed
import com.slapps.cupertino.icons.outlined.Bookmark
import com.slapps.cupertino.icons.outlined.BookmarkSlash
import com.slapps.cupertino.icons.outlined.Brain
import com.slapps.cupertino.icons.outlined.BrainHeadProfile
import com.slapps.cupertino.icons.outlined.Briefcase
import com.slapps.cupertino.icons.outlined.BubbleLeft
import com.slapps.cupertino.icons.outlined.BubbleRight
import com.slapps.cupertino.icons.outlined.Building
import com.slapps.cupertino.icons.outlined.Building2
import com.slapps.cupertino.icons.outlined.Burn
import com.slapps.cupertino.icons.outlined.Burst
import com.slapps.cupertino.icons.outlined.CableConnector
import com.slapps.cupertino.icons.outlined.CableConnectorHorizontal
import com.slapps.cupertino.icons.outlined.Calendar
import com.slapps.cupertino.icons.outlined.CalendarBadgePlus
import com.slapps.cupertino.icons.outlined.Camera
import com.slapps.cupertino.icons.outlined.CameraCircle
import com.slapps.cupertino.icons.outlined.CameraFilters
import com.slapps.cupertino.icons.outlined.CameraViewfinder
import com.slapps.cupertino.icons.outlined.Candybarphone
import com.slapps.cupertino.icons.outlined.Capslock
import com.slapps.cupertino.icons.outlined.Car
import com.slapps.cupertino.icons.outlined.Cart
import com.slapps.cupertino.icons.outlined.CartBadgeMinus
import com.slapps.cupertino.icons.outlined.CartBadgePlus
import com.slapps.cupertino.icons.outlined.Case
import com.slapps.cupertino.icons.outlined.Centsign
import com.slapps.cupertino.icons.outlined.Character
import com.slapps.cupertino.icons.outlined.ChartBar
import com.slapps.cupertino.icons.outlined.ChartLineDowntrendXyaxis
import com.slapps.cupertino.icons.outlined.ChartLineUptrendXyaxis
import com.slapps.cupertino.icons.outlined.CheckerboardShield
import com.slapps.cupertino.icons.outlined.Checklist
import com.slapps.cupertino.icons.outlined.ChecklistChecked
import com.slapps.cupertino.icons.outlined.ChecklistUnchecked
import com.slapps.cupertino.icons.outlined.Checkmark
import com.slapps.cupertino.icons.outlined.CheckmarkCircle
import com.slapps.cupertino.icons.outlined.CheckmarkIcloud
import com.slapps.cupertino.icons.outlined.CheckmarkMessage
import com.slapps.cupertino.icons.outlined.CheckmarkSeal
import com.slapps.cupertino.icons.outlined.CheckmarkShield
import com.slapps.cupertino.icons.outlined.CheckmarkSquare
import com.slapps.cupertino.icons.outlined.ChevronBackward
import com.slapps.cupertino.icons.outlined.ChevronDown
import com.slapps.cupertino.icons.outlined.ChevronForward
import com.slapps.cupertino.icons.outlined.ChevronLeftForwardslashChevronRight
import com.slapps.cupertino.icons.outlined.ChevronUp
import com.slapps.cupertino.icons.outlined.Clear
import com.slapps.cupertino.icons.outlined.Clipboard
import com.slapps.cupertino.icons.outlined.Clock
import com.slapps.cupertino.icons.outlined.ClockArrowCirclepath
import com.slapps.cupertino.icons.outlined.Cloud
import com.slapps.cupertino.icons.outlined.Command
import com.slapps.cupertino.icons.outlined.CompassDrawing
import com.slapps.cupertino.icons.outlined.Cone
import com.slapps.cupertino.icons.outlined.Cpu
import com.slapps.cupertino.icons.outlined.Creditcard
import com.slapps.cupertino.icons.outlined.CreditcardTrianglebadgeExclamationmark
import com.slapps.cupertino.icons.outlined.Crop
import com.slapps.cupertino.icons.outlined.CropRotate
import com.slapps.cupertino.icons.outlined.Cross
import com.slapps.cupertino.icons.outlined.CrossCircle
import com.slapps.cupertino.icons.outlined.CrossVial
import com.slapps.cupertino.icons.outlined.Crown
import com.slapps.cupertino.icons.outlined.Cube
import com.slapps.cupertino.icons.outlined.CupAndSaucer
import com.slapps.cupertino.icons.outlined.Curlybraces
import com.slapps.cupertino.icons.outlined.CursorarrowRays
import com.slapps.cupertino.icons.outlined.DeleteLeft
import com.slapps.cupertino.icons.outlined.DeleteRight
import com.slapps.cupertino.icons.outlined.Desktopcomputer
import com.slapps.cupertino.icons.outlined.Dice
import com.slapps.cupertino.icons.outlined.Display
import com.slapps.cupertino.icons.outlined.Divide
import com.slapps.cupertino.icons.outlined.Doc
import com.slapps.cupertino.icons.outlined.DocBadgeArrowUp
import com.slapps.cupertino.icons.outlined.DocBadgePlus
import com.slapps.cupertino.icons.outlined.DocOnDoc
import com.slapps.cupertino.icons.outlined.DocPlaintext
import com.slapps.cupertino.icons.outlined.DocText
import com.slapps.cupertino.icons.outlined.DocTextMagnifyingglass
import com.slapps.cupertino.icons.outlined.Dollarsign
import com.slapps.cupertino.icons.outlined.DollarsignArrowCirclepath
import com.slapps.cupertino.icons.outlined.DoorLeftHandClosed
import com.slapps.cupertino.icons.outlined.DoorLeftHandOpen
import com.slapps.cupertino.icons.outlined.DotRadiowavesLeftAndRight
import com.slapps.cupertino.icons.outlined.DotRadiowavesUpForward
import com.slapps.cupertino.icons.outlined.Drop
import com.slapps.cupertino.icons.outlined.Ear
import com.slapps.cupertino.icons.outlined.Earpods
import com.slapps.cupertino.icons.outlined.Ellipsis
import com.slapps.cupertino.icons.outlined.EllipsisBubble
import com.slapps.cupertino.icons.outlined.EllipsisCircle
import com.slapps.cupertino.icons.outlined.EllipsisCurlybraces
import com.slapps.cupertino.icons.outlined.EllipsisMessage
import com.slapps.cupertino.icons.outlined.Envelope
import com.slapps.cupertino.icons.outlined.EnvelopeBadge
import com.slapps.cupertino.icons.outlined.EnvelopeCircle
import com.slapps.cupertino.icons.outlined.EnvelopeOpen
import com.slapps.cupertino.icons.outlined.Eraser
import com.slapps.cupertino.icons.outlined.Eurosign
import com.slapps.cupertino.icons.outlined.Exclamationmark
import com.slapps.cupertino.icons.outlined.Exclamationmark2
import com.slapps.cupertino.icons.outlined.Exclamationmark3
import com.slapps.cupertino.icons.outlined.ExclamationmarkArrowTriangle2Circlepath
import com.slapps.cupertino.icons.outlined.ExclamationmarkCircle
import com.slapps.cupertino.icons.outlined.ExclamationmarkIcloud
import com.slapps.cupertino.icons.outlined.ExclamationmarkSquare
import com.slapps.cupertino.icons.outlined.ExclamationmarkTriangle
import com.slapps.cupertino.icons.outlined.Externaldrive
import com.slapps.cupertino.icons.outlined.Eye
import com.slapps.cupertino.icons.outlined.EyeSlash
import com.slapps.cupertino.icons.outlined.Eyebrow
import com.slapps.cupertino.icons.outlined.Eyedropper
import com.slapps.cupertino.icons.outlined.Eyeglasses
import com.slapps.cupertino.icons.outlined.Eyes
import com.slapps.cupertino.icons.outlined.FaceSmiling
import com.slapps.cupertino.icons.outlined.FaceSmilingInverse
import com.slapps.cupertino.icons.outlined.Faceid
import com.slapps.cupertino.icons.outlined.Facemask
import com.slapps.cupertino.icons.outlined.Fanblades
import com.slapps.cupertino.icons.outlined.FanbladesSlash
import com.slapps.cupertino.icons.outlined.Fibrechannel
import com.slapps.cupertino.icons.outlined.FigureStand
import com.slapps.cupertino.icons.outlined.FigureWalk
import com.slapps.cupertino.icons.outlined.Film
import com.slapps.cupertino.icons.outlined.Flag
import com.slapps.cupertino.icons.outlined.Flag2Crossed
import com.slapps.cupertino.icons.outlined.FlagCheckered2Crossed
import com.slapps.cupertino.icons.outlined.FlagSlash
import com.slapps.cupertino.icons.outlined.Flame
import com.slapps.cupertino.icons.outlined.Flowchart
import com.slapps.cupertino.icons.outlined.Folder
import com.slapps.cupertino.icons.outlined.FolderBadgePlus
import com.slapps.cupertino.icons.outlined.Football
import com.slapps.cupertino.icons.outlined.ForkKnife
import com.slapps.cupertino.icons.outlined.ForkKnifeCircle
import com.slapps.cupertino.icons.outlined.Forward
import com.slapps.cupertino.icons.outlined.ForwardEnd
import com.slapps.cupertino.icons.outlined.Francsign
import com.slapps.cupertino.icons.outlined.Fuelpump
import com.slapps.cupertino.icons.outlined.Gamecontroller
import com.slapps.cupertino.icons.outlined.Gear
import com.slapps.cupertino.icons.outlined.Gearshape
import com.slapps.cupertino.icons.outlined.Gearshape2
import com.slapps.cupertino.icons.outlined.Gift
import com.slapps.cupertino.icons.outlined.Giftcard
import com.slapps.cupertino.icons.outlined.GlobeDesk
import com.slapps.cupertino.icons.outlined.Gobackward
import com.slapps.cupertino.icons.outlined.Goforward
import com.slapps.cupertino.icons.outlined.Graduationcap
import com.slapps.cupertino.icons.outlined.Grid
import com.slapps.cupertino.icons.outlined.Hammer
import com.slapps.cupertino.icons.outlined.HandDraw
import com.slapps.cupertino.icons.outlined.HandPointUp
import com.slapps.cupertino.icons.outlined.HandPointUpLeft
import com.slapps.cupertino.icons.outlined.HandRaised
import com.slapps.cupertino.icons.outlined.HandRaisedSlash
import com.slapps.cupertino.icons.outlined.HandTap
import com.slapps.cupertino.icons.outlined.HandThumbsdown
import com.slapps.cupertino.icons.outlined.HandThumbsup
import com.slapps.cupertino.icons.outlined.HandWave
import com.slapps.cupertino.icons.outlined.HandsSparkles
import com.slapps.cupertino.icons.outlined.Headphones
import com.slapps.cupertino.icons.outlined.HeadphonesCircle
import com.slapps.cupertino.icons.outlined.Heart
import com.slapps.cupertino.icons.outlined.HeartCircle
import com.slapps.cupertino.icons.outlined.HeartSlash
import com.slapps.cupertino.icons.outlined.HeartTextSquare
import com.slapps.cupertino.icons.outlined.Hifispeaker
import com.slapps.cupertino.icons.outlined.Highlighter
import com.slapps.cupertino.icons.outlined.Homekit
import com.slapps.cupertino.icons.outlined.Homepod
import com.slapps.cupertino.icons.outlined.Homepodmini
import com.slapps.cupertino.icons.outlined.Hourglass
import com.slapps.cupertino.icons.outlined.House
import com.slapps.cupertino.icons.outlined.Hryvniasign
import com.slapps.cupertino.icons.outlined.Icloud
import com.slapps.cupertino.icons.outlined.IcloudAndArrowDown
import com.slapps.cupertino.icons.outlined.IcloudAndArrowUp
import com.slapps.cupertino.icons.outlined.Infinity
import com.slapps.cupertino.icons.outlined.Info
import com.slapps.cupertino.icons.outlined.InfoBubble
import com.slapps.cupertino.icons.outlined.InfoCircle
import com.slapps.cupertino.icons.outlined.InfoSquare
import com.slapps.cupertino.icons.outlined.Ipad
import com.slapps.cupertino.icons.outlined.IpadAndIphone
import com.slapps.cupertino.icons.outlined.IpadHomebutton
import com.slapps.cupertino.icons.outlined.Iphone
import com.slapps.cupertino.icons.outlined.IphoneBadgePlay
import com.slapps.cupertino.icons.outlined.IphoneHomebutton
import com.slapps.cupertino.icons.outlined.IphoneHomebuttonRadiowavesLeftAndRight
import com.slapps.cupertino.icons.outlined.IphoneRadiowavesLeftAndRight
import com.slapps.cupertino.icons.outlined.Key
import com.slapps.cupertino.icons.outlined.KeyIcloud
import com.slapps.cupertino.icons.outlined.Keyboard
import com.slapps.cupertino.icons.outlined.Lanyardcard
import com.slapps.cupertino.icons.outlined.Laptopcomputer
import com.slapps.cupertino.icons.outlined.LaptopcomputerAndIpad
import com.slapps.cupertino.icons.outlined.LaptopcomputerAndIphone
import com.slapps.cupertino.icons.outlined.Leaf
import com.slapps.cupertino.icons.outlined.Level
import com.slapps.cupertino.icons.outlined.Lifepreserver
import com.slapps.cupertino.icons.outlined.LightBeaconMax
import com.slapps.cupertino.icons.outlined.LightMax
import com.slapps.cupertino.icons.outlined.LightMin
import com.slapps.cupertino.icons.outlined.Lightbulb
import com.slapps.cupertino.icons.outlined.LightbulbSlash
import com.slapps.cupertino.icons.outlined.Link
import com.slapps.cupertino.icons.outlined.LinkBadgePlus
import com.slapps.cupertino.icons.outlined.LinkCircle
import com.slapps.cupertino.icons.outlined.Lirasign
import com.slapps.cupertino.icons.outlined.ListBullet
import com.slapps.cupertino.icons.outlined.ListBulletCircle
import com.slapps.cupertino.icons.outlined.ListBulletClipboard
import com.slapps.cupertino.icons.outlined.ListBulletIndent
import com.slapps.cupertino.icons.outlined.ListClipboard
import com.slapps.cupertino.icons.outlined.ListNumber
import com.slapps.cupertino.icons.outlined.Livephoto
import com.slapps.cupertino.icons.outlined.Location
import com.slapps.cupertino.icons.outlined.Lock
import com.slapps.cupertino.icons.outlined.LockCircle
import com.slapps.cupertino.icons.outlined.LockOpen
import com.slapps.cupertino.icons.outlined.LockSlash
import com.slapps.cupertino.icons.outlined.Macwindow
import com.slapps.cupertino.icons.outlined.MacwindowBadgePlus
import com.slapps.cupertino.icons.outlined.Magazine
import com.slapps.cupertino.icons.outlined.Mail
import com.slapps.cupertino.icons.outlined.MailStack
import com.slapps.cupertino.icons.outlined.Map
import com.slapps.cupertino.icons.outlined.Mappin
import com.slapps.cupertino.icons.outlined.MappinAndEllipse
import com.slapps.cupertino.icons.outlined.MappinSlash
import com.slapps.cupertino.icons.outlined.Medal
import com.slapps.cupertino.icons.outlined.Megaphone
import com.slapps.cupertino.icons.outlined.Memories
import com.slapps.cupertino.icons.outlined.MenubarRectangle
import com.slapps.cupertino.icons.outlined.Menucard
import com.slapps.cupertino.icons.outlined.Message
import com.slapps.cupertino.icons.outlined.MessageBadge
import com.slapps.cupertino.icons.outlined.Mic
import com.slapps.cupertino.icons.outlined.MicSlash
import com.slapps.cupertino.icons.outlined.Minus
import com.slapps.cupertino.icons.outlined.MinusCircle
import com.slapps.cupertino.icons.outlined.MinusMagnifyingglass
import com.slapps.cupertino.icons.outlined.Moon
import com.slapps.cupertino.icons.outlined.MoonStars
import com.slapps.cupertino.icons.outlined.Mount
import com.slapps.cupertino.icons.outlined.Multiply
import com.slapps.cupertino.icons.outlined.MusicMic
import com.slapps.cupertino.icons.outlined.MusicNote
import com.slapps.cupertino.icons.outlined.MusicNoteList
import com.slapps.cupertino.icons.outlined.MusicQuarternote3
import com.slapps.cupertino.icons.outlined.Network
import com.slapps.cupertino.icons.outlined.Newspaper
import com.slapps.cupertino.icons.outlined.Nosign
import com.slapps.cupertino.icons.outlined.NoteText
import com.slapps.cupertino.icons.outlined.NoteTextBadgePlus
import com.slapps.cupertino.icons.outlined.Number
import com.slapps.cupertino.icons.outlined.Opticaldisc
import com.slapps.cupertino.icons.outlined.Option
import com.slapps.cupertino.icons.outlined.Paintbrush
import com.slapps.cupertino.icons.outlined.PaintbrushPointed
import com.slapps.cupertino.icons.outlined.Paintpalette
import com.slapps.cupertino.icons.outlined.Paperclip
import com.slapps.cupertino.icons.outlined.PaperclipBadgeEllipsis
import com.slapps.cupertino.icons.outlined.PaperclipCircle
import com.slapps.cupertino.icons.outlined.Paperplane
import com.slapps.cupertino.icons.outlined.Paragraphsign
import com.slapps.cupertino.icons.outlined.PartyPopper
import com.slapps.cupertino.icons.outlined.Pause
import com.slapps.cupertino.icons.outlined.PauseCircle
import com.slapps.cupertino.icons.outlined.Pawprint
import com.slapps.cupertino.icons.outlined.Pencil
import com.slapps.cupertino.icons.outlined.PencilCircle
import com.slapps.cupertino.icons.outlined.PencilTipCropCircle
import com.slapps.cupertino.icons.outlined.Percent
import com.slapps.cupertino.icons.outlined.Person
import com.slapps.cupertino.icons.outlined.Person2
import com.slapps.cupertino.icons.outlined.PersonAndBackgroundDotted
import com.slapps.cupertino.icons.outlined.PersonCircle
import com.slapps.cupertino.icons.outlined.PersonCropCircle
import com.slapps.cupertino.icons.outlined.PersonCropCircleBadgeMinus
import com.slapps.cupertino.icons.outlined.PersonCropCircleBadgePlus
import com.slapps.cupertino.icons.outlined.PersonCropSquare
import com.slapps.cupertino.icons.outlined.PersonIcloud
import com.slapps.cupertino.icons.outlined.PersonTextRectangle
import com.slapps.cupertino.icons.outlined.PersonWave2
import com.slapps.cupertino.icons.outlined.Personalhotspot
import com.slapps.cupertino.icons.outlined.Phone
import com.slapps.cupertino.icons.outlined.PhoneAndWaveform
import com.slapps.cupertino.icons.outlined.PhoneArrowDownLeft
import com.slapps.cupertino.icons.outlined.PhoneArrowUpRight
import com.slapps.cupertino.icons.outlined.PhoneBadgePlus
import com.slapps.cupertino.icons.outlined.PhoneCircle
import com.slapps.cupertino.icons.outlined.PhoneConnection
import com.slapps.cupertino.icons.outlined.Photo
import com.slapps.cupertino.icons.outlined.PhotoStack
import com.slapps.cupertino.icons.outlined.PhotoTv
import com.slapps.cupertino.icons.outlined.Pill
import com.slapps.cupertino.icons.outlined.Pin
import com.slapps.cupertino.icons.outlined.PinCircle
import com.slapps.cupertino.icons.outlined.PinSlash
import com.slapps.cupertino.icons.outlined.Pip
import com.slapps.cupertino.icons.outlined.PipEnter
import com.slapps.cupertino.icons.outlined.PipExit
import com.slapps.cupertino.icons.outlined.Play
import com.slapps.cupertino.icons.outlined.PlayCircle
import com.slapps.cupertino.icons.outlined.PlayDisplay
import com.slapps.cupertino.icons.outlined.Plus
import com.slapps.cupertino.icons.outlined.PlusApp
import com.slapps.cupertino.icons.outlined.PlusBubble
import com.slapps.cupertino.icons.outlined.PlusCircle
import com.slapps.cupertino.icons.outlined.PlusMagnifyingglass
import com.slapps.cupertino.icons.outlined.PlusMessage
import com.slapps.cupertino.icons.outlined.PlusSquare
import com.slapps.cupertino.icons.outlined.PlusViewfinder
import com.slapps.cupertino.icons.outlined.Popcorn
import com.slapps.cupertino.icons.outlined.Power
import com.slapps.cupertino.icons.outlined.PowerCircle
import com.slapps.cupertino.icons.outlined.Printer
import com.slapps.cupertino.icons.outlined.Puzzlepiece
import com.slapps.cupertino.icons.outlined.PuzzlepieceExtension
import com.slapps.cupertino.icons.outlined.Qrcode
import com.slapps.cupertino.icons.outlined.QrcodeViewfinder
import com.slapps.cupertino.icons.outlined.Questionmark
import com.slapps.cupertino.icons.outlined.QuestionmarkApp
import com.slapps.cupertino.icons.outlined.QuestionmarkCircle
import com.slapps.cupertino.icons.outlined.QuestionmarkFolder
import com.slapps.cupertino.icons.outlined.QuestionmarkSquare
import com.slapps.cupertino.icons.outlined.QuoteClosing
import com.slapps.cupertino.icons.outlined.QuoteOpening
import com.slapps.cupertino.icons.outlined.Rays
import com.slapps.cupertino.icons.outlined.RecordCircle
import com.slapps.cupertino.icons.outlined.Recordingtape
import com.slapps.cupertino.icons.outlined.RectangleArrowtriangle2Outward
import com.slapps.cupertino.icons.outlined.RectangleConnectedToLineBelow
import com.slapps.cupertino.icons.outlined.RectanglePortraitAndArrowForward
import com.slapps.cupertino.icons.outlined.RectanglePortraitArrowtriangle2Outward
import com.slapps.cupertino.icons.outlined.RectangleStack
import com.slapps.cupertino.icons.outlined.Repeat
import com.slapps.cupertino.icons.outlined.Rosette
import com.slapps.cupertino.icons.outlined.Rotate3d
import com.slapps.cupertino.icons.outlined.RotateLeft
import com.slapps.cupertino.icons.outlined.RotateRight
import com.slapps.cupertino.icons.outlined.Rublesign
import com.slapps.cupertino.icons.outlined.Ruler
import com.slapps.cupertino.icons.outlined.Safari
import com.slapps.cupertino.icons.outlined.Scalemass
import com.slapps.cupertino.icons.outlined.Scissors
import com.slapps.cupertino.icons.outlined.Scope
import com.slapps.cupertino.icons.outlined.Scribble
import com.slapps.cupertino.icons.outlined.ScribbleVariable
import com.slapps.cupertino.icons.outlined.Scroll
import com.slapps.cupertino.icons.outlined.ServerRack
import com.slapps.cupertino.icons.outlined.Shareplay
import com.slapps.cupertino.icons.outlined.ShareplaySlash
import com.slapps.cupertino.icons.outlined.ShazamLogo
import com.slapps.cupertino.icons.outlined.Shield
import com.slapps.cupertino.icons.outlined.ShieldSlash
import com.slapps.cupertino.icons.outlined.Shippingbox
import com.slapps.cupertino.icons.outlined.Shuffle
import com.slapps.cupertino.icons.outlined.SidebarLeft
import com.slapps.cupertino.icons.outlined.SidebarRight
import com.slapps.cupertino.icons.outlined.Simcard
import com.slapps.cupertino.icons.outlined.Skew
import com.slapps.cupertino.icons.outlined.SliderHorizontal3
import com.slapps.cupertino.icons.outlined.SliderVertical3
import com.slapps.cupertino.icons.outlined.Snowflake
import com.slapps.cupertino.icons.outlined.Soccerball
import com.slapps.cupertino.icons.outlined.Space
import com.slapps.cupertino.icons.outlined.Sparkle
import com.slapps.cupertino.icons.outlined.Sparkles
import com.slapps.cupertino.icons.outlined.Speaker
import com.slapps.cupertino.icons.outlined.SpeakerMinus
import com.slapps.cupertino.icons.outlined.SpeakerPlus
import com.slapps.cupertino.icons.outlined.SpeakerSlash
import com.slapps.cupertino.icons.outlined.SpeakerWave2
import com.slapps.cupertino.icons.outlined.Speedometer
import com.slapps.cupertino.icons.outlined.Square3Layers3dDownLeft
import com.slapps.cupertino.icons.outlined.Square3Layers3dDownRight
import com.slapps.cupertino.icons.outlined.SquareAndArrowUp
import com.slapps.cupertino.icons.outlined.SquareAndPencil
import com.slapps.cupertino.icons.outlined.SquareOnSquare
import com.slapps.cupertino.icons.outlined.SquareSplit1x2
import com.slapps.cupertino.icons.outlined.SquareSplit2x1
import com.slapps.cupertino.icons.outlined.SquareStack
import com.slapps.cupertino.icons.outlined.SquareStack3dUp
import com.slapps.cupertino.icons.outlined.Star
import com.slapps.cupertino.icons.outlined.StarSlash
import com.slapps.cupertino.icons.outlined.Staroflife
import com.slapps.cupertino.icons.outlined.Sterlingsign
import com.slapps.cupertino.icons.outlined.Stethoscope
import com.slapps.cupertino.icons.outlined.Stop
import com.slapps.cupertino.icons.outlined.StopCircle
import com.slapps.cupertino.icons.outlined.Suitcase
import com.slapps.cupertino.icons.outlined.Sum
import com.slapps.cupertino.icons.outlined.SunMax
import com.slapps.cupertino.icons.outlined.Swift
import com.slapps.cupertino.icons.outlined.Tag
import com.slapps.cupertino.icons.outlined.Target
import com.slapps.cupertino.icons.outlined.TennisRacket
import com.slapps.cupertino.icons.outlined.Terminal
import com.slapps.cupertino.icons.outlined.TextBubble
import com.slapps.cupertino.icons.outlined.TextMagnifyingglass
import com.slapps.cupertino.icons.outlined.Theatermasks
import com.slapps.cupertino.icons.outlined.Timer
import com.slapps.cupertino.icons.outlined.Touchid
import com.slapps.cupertino.icons.outlined.Trash
import com.slapps.cupertino.icons.outlined.TrashSlash
import com.slapps.cupertino.icons.outlined.TrayAndArrowDown
import com.slapps.cupertino.icons.outlined.TrayAndArrowUp
import com.slapps.cupertino.icons.outlined.Trophy
import com.slapps.cupertino.icons.outlined.Tshirt
import com.slapps.cupertino.icons.outlined.Tv
import com.slapps.cupertino.icons.outlined.Umbrella
import com.slapps.cupertino.icons.outlined.Video
import com.slapps.cupertino.icons.outlined.VideoCircle
import com.slapps.cupertino.icons.outlined.VideoSlash
import com.slapps.cupertino.icons.outlined.Volleyball
import com.slapps.cupertino.icons.outlined.WalletPass
import com.slapps.cupertino.icons.outlined.WandAndStars
import com.slapps.cupertino.icons.outlined.WandAndStarsInverse
import com.slapps.cupertino.icons.outlined.Waveform
import com.slapps.cupertino.icons.outlined.WaveformAndMagnifyingglass
import com.slapps.cupertino.icons.outlined.WaveformAndMic
import com.slapps.cupertino.icons.outlined.WaveformPathEcg
import com.slapps.cupertino.icons.outlined.WebCamera
import com.slapps.cupertino.icons.outlined.Wifi
import com.slapps.cupertino.icons.outlined.WifiExclamationmark
import com.slapps.cupertino.icons.outlined.WifiRouter
import com.slapps.cupertino.icons.outlined.WifiSlash
import com.slapps.cupertino.icons.outlined.Wind
import com.slapps.cupertino.icons.outlined.Wineglass
import com.slapps.cupertino.icons.outlined.WrenchAndScrewdriver
import com.slapps.cupertino.icons.outlined.Xmark
import com.slapps.cupertino.icons.outlined.XmarkApp
import com.slapps.cupertino.icons.outlined.XmarkBin
import com.slapps.cupertino.icons.outlined.XmarkCircle
import com.slapps.cupertino.icons.outlined.XmarkIcloud
import com.slapps.cupertino.icons.outlined.XmarkSeal
import com.slapps.cupertino.icons.outlined.XmarkShield
import com.slapps.cupertino.icons.outlined.Yensign
import com.slapps.cupertino.icons.outlined.Zzz
import com.slapps.cupertino.icons.outlined._4kTv

@OptIn(ExperimentalCupertinoApi::class)
@Composable
fun IconsScreen(
    component: IconsComponent
) {

    var isOutlined by remember {
        mutableStateOf(true)
    }

    val pagerState = rememberPagerState(
        pageCount = { 2 }
    )

    LaunchedEffect(isOutlined){
        pagerState.animateScrollToPage(if (isOutlined) 0 else 1)
    }

    CupertinoScaffold(
        topBar = {
            CupertinoTopAppBar(
                navigationIcon = {

                    AdaptiveWidget(
                        cupertino = {
                            CupertinoNavigateBackButton(
                                onClick = component::onNavigateBack,
                            ) {
                                CupertinoText("Back")
                            }
                        },
                        material = {
                            IconButton(
                                onClick = component::onNavigateBack
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    )
                },
                title = {
                    CupertinoSegmentedControl(
                        modifier = Modifier
                            .width(200.dp),
                        selectedTabIndex = if (isOutlined) 0 else 1
                    ) {
                        CupertinoSegmentedControlTab(
                            isSelected = isOutlined,
                            onClick = {
                                isOutlined = true
                            }
                        ) {
                            CupertinoText("Outlined")
                        }
                        CupertinoSegmentedControlTab(
                            isSelected = !isOutlined,
                            onClick = {
                                isOutlined = false

                            }
                        ) {
                            CupertinoText("Filled")
                        }
                    }
                }
            )
        }
    ) { pv ->

        var selectedIcon by remember {
            mutableStateOf<ImageVector?>(null)
        }
        if (selectedIcon != null) {
            CupertinoAlertDialog(
                title = {
                    CupertinoIcon(
                        imageVector = selectedIcon!!,
                        contentDescription = null
                    )
                },
                message = {
                    CupertinoText(
                        "CupertinoIcon.${if (isOutlined) "Outlined" else "Filled"}.${selectedIcon!!.name}"
                    )
                },
                onDismissRequest = {
                    selectedIcon = null
                }
            ){
                default(onClick = {
                    selectedIcon = null
                }){
                    CupertinoText("Close")
                }
            }
        }

        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false
        ) { page ->
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Adaptive(48.dp),
                contentPadding = pv
            ) {
                items(if (page == 0) Outlined else Filled) {
                    CupertinoIconButton(
                        onClick = {
                            selectedIcon = it
                        }
                    ) {
                        CupertinoIcon(
                            imageVector = it,
                            contentDescription = it.name
                        )
                    }
                }
            }
        }
    }
}

private val Outlined = listOf(
    CupertinoIcons.Outlined.Airplane,
    CupertinoIcons.Outlined.AirplaneArrival,
    CupertinoIcons.Outlined.AirplaneDeparture,
    CupertinoIcons.Outlined.Airplayaudio,
    CupertinoIcons.Outlined.Airpods,
    CupertinoIcons.Outlined.AirpodsGen3,
    CupertinoIcons.Outlined.Airpodsmax,
    CupertinoIcons.Outlined.Airpodspro,
    CupertinoIcons.Outlined.Airtag,
    CupertinoIcons.Outlined.Alarm,
    CupertinoIcons.Outlined.Alt,
    CupertinoIcons.Outlined.Angle,
    CupertinoIcons.Outlined.AntennaRadiowavesLeftAndRight,
    CupertinoIcons.Outlined.AntennaRadiowavesLeftAndRightSlash,
    CupertinoIcons.Outlined.AppleLogo,
    CupertinoIcons.Outlined.Applepencil,
    CupertinoIcons.Outlined.Appletv,
    CupertinoIcons.Outlined.Applewatch,
    CupertinoIcons.Outlined.ApplewatchRadiowavesLeftAndRight,
    CupertinoIcons.Outlined.ApplewatchWatchface,
    CupertinoIcons.Outlined.Archivebox,
    CupertinoIcons.Outlined.Arrow3Trianglepath,
    CupertinoIcons.Outlined.ArrowClockwise,
    CupertinoIcons.Outlined.ArrowCounterclockwise,
    CupertinoIcons.Outlined.ArrowCounterclockwiseIcloud,
    CupertinoIcons.Outlined.ArrowDown,
    CupertinoIcons.Outlined.ArrowDownAndLineHorizontalAndArrowUp,
    CupertinoIcons.Outlined.ArrowDownCircle,
    CupertinoIcons.Outlined.ArrowDownDoc,
    CupertinoIcons.Outlined.ArrowDownRightAndArrowUpLeft,
    CupertinoIcons.Outlined.ArrowDownToLine,
    CupertinoIcons.Outlined.ArrowLeftAndRight,
    CupertinoIcons.Outlined.ArrowLeftArrowRight,
    CupertinoIcons.Outlined.ArrowTriangle2Circlepath,
    CupertinoIcons.Outlined.ArrowTriangle2CirclepathCamera,
    CupertinoIcons.Outlined.ArrowTriangleBranch,
    CupertinoIcons.Outlined.ArrowTurnDownLeft,
    CupertinoIcons.Outlined.ArrowTurnDownRight,
    CupertinoIcons.Outlined.ArrowTurnRightUp,
    CupertinoIcons.Outlined.ArrowTurnUpForwardIphone,
    CupertinoIcons.Outlined.ArrowTurnUpLeft,
    CupertinoIcons.Outlined.ArrowTurnUpRight,
    CupertinoIcons.Outlined.ArrowUpAndDown,
    CupertinoIcons.Outlined.ArrowUpArrowDown,
    CupertinoIcons.Outlined.ArrowUpDoc,
    CupertinoIcons.Outlined.ArrowUpLeftAndArrowDownRight,
    CupertinoIcons.Outlined.ArrowUturnLeft,
    CupertinoIcons.Outlined.ArrowUturnRight,
    CupertinoIcons.Outlined.ArrowshapeTurnUpLeft,
    CupertinoIcons.Outlined.ArrowshapeTurnUpLeft2,
    CupertinoIcons.Outlined.At,
    CupertinoIcons.Outlined.Backward,
    CupertinoIcons.Outlined.BackwardEnd,
    CupertinoIcons.Outlined.Bag,
    CupertinoIcons.Outlined.BagBadgeMinus,
    CupertinoIcons.Outlined.BagBadgePlus,
    CupertinoIcons.Outlined.Balloon,
    CupertinoIcons.Outlined.Bandage,
    CupertinoIcons.Outlined.Banknote,
    CupertinoIcons.Outlined.Barcode,
    CupertinoIcons.Outlined.BarcodeViewfinder,
    CupertinoIcons.Outlined.Baseball,
    CupertinoIcons.Outlined.Basket,
    CupertinoIcons.Outlined.Basketball,
    CupertinoIcons.Outlined.Battery100,
    CupertinoIcons.Outlined.BedDouble,
    CupertinoIcons.Outlined.Bell,
    CupertinoIcons.Outlined.BellAndWavesLeftAndRight,
    CupertinoIcons.Outlined.BellBadge,
    CupertinoIcons.Outlined.BellCircle,
    CupertinoIcons.Outlined.BellSlash,
    CupertinoIcons.Outlined.Bicycle,
    CupertinoIcons.Outlined.Binoculars,
    CupertinoIcons.Outlined.BirthdayCake,
    CupertinoIcons.Outlined.Bitcoinsign,
    CupertinoIcons.Outlined.Bolt,
    CupertinoIcons.Outlined.BoltHorizontal,
    CupertinoIcons.Outlined.BoltSlash,
    CupertinoIcons.Outlined.Book,
    CupertinoIcons.Outlined.BookCircle,
    CupertinoIcons.Outlined.BookClosed,
    CupertinoIcons.Outlined.Bookmark,
    CupertinoIcons.Outlined.BookmarkSlash,
    CupertinoIcons.Outlined.Brain,
    CupertinoIcons.Outlined.BrainHeadProfile,
    CupertinoIcons.Outlined.Briefcase,
    CupertinoIcons.Outlined.BubbleLeft,
    CupertinoIcons.Outlined.BubbleRight,
    CupertinoIcons.Outlined.Building,
    CupertinoIcons.Outlined.Building2,
    CupertinoIcons.Outlined.Burn,
    CupertinoIcons.Outlined.Burst,
    CupertinoIcons.Outlined.CableConnector,
    CupertinoIcons.Outlined.CableConnectorHorizontal,
    CupertinoIcons.Outlined.Calendar,
    CupertinoIcons.Outlined.CalendarBadgePlus,
    CupertinoIcons.Outlined.Camera,
    CupertinoIcons.Outlined.CameraCircle,
    CupertinoIcons.Outlined.CameraFilters,
    CupertinoIcons.Outlined.CameraViewfinder,
    CupertinoIcons.Outlined.Candybarphone,
    CupertinoIcons.Outlined.Capslock,
    CupertinoIcons.Outlined.Car,
    CupertinoIcons.Outlined.Cart,
    CupertinoIcons.Outlined.CartBadgeMinus,
    CupertinoIcons.Outlined.CartBadgePlus,
    CupertinoIcons.Outlined.Case,
    CupertinoIcons.Outlined.Centsign,
    CupertinoIcons.Outlined.Character,
    CupertinoIcons.Outlined.ChartBar,
    CupertinoIcons.Outlined.ChartLineDowntrendXyaxis,
    CupertinoIcons.Outlined.ChartLineUptrendXyaxis,
    CupertinoIcons.Outlined.CheckerboardShield,
    CupertinoIcons.Outlined.Checklist,
    CupertinoIcons.Outlined.ChecklistChecked,
    CupertinoIcons.Outlined.ChecklistUnchecked,
    CupertinoIcons.Outlined.Checkmark,
    CupertinoIcons.Outlined.CheckmarkCircle,
    CupertinoIcons.Outlined.CheckmarkIcloud,
    CupertinoIcons.Outlined.CheckmarkMessage,
    CupertinoIcons.Outlined.CheckmarkSeal,
    CupertinoIcons.Outlined.CheckmarkShield,
    CupertinoIcons.Outlined.CheckmarkSquare,
    CupertinoIcons.Outlined.ChevronBackward,
    CupertinoIcons.Outlined.ChevronDown,
    CupertinoIcons.Outlined.ChevronForward,
    CupertinoIcons.Outlined.ChevronLeftForwardslashChevronRight,
    CupertinoIcons.Outlined.ChevronUp,
    CupertinoIcons.Outlined.Clear,
    CupertinoIcons.Outlined.Clipboard,
    CupertinoIcons.Outlined.Clock,
    CupertinoIcons.Outlined.ClockArrowCirclepath,
    CupertinoIcons.Outlined.Cloud,
    CupertinoIcons.Outlined.Command,
    CupertinoIcons.Outlined.CompassDrawing,
    CupertinoIcons.Outlined.Cone,
    CupertinoIcons.Outlined.Cpu,
    CupertinoIcons.Outlined.Creditcard,
    CupertinoIcons.Outlined.CreditcardTrianglebadgeExclamationmark,
    CupertinoIcons.Outlined.Crop,
    CupertinoIcons.Outlined.CropRotate,
    CupertinoIcons.Outlined.Cross,
    CupertinoIcons.Outlined.CrossCircle,
    CupertinoIcons.Outlined.CrossVial,
    CupertinoIcons.Outlined.Crown,
    CupertinoIcons.Outlined.Cube,
    CupertinoIcons.Outlined.CupAndSaucer,
    CupertinoIcons.Outlined.Curlybraces,
    CupertinoIcons.Outlined.CursorarrowRays,
    CupertinoIcons.Outlined.DeleteLeft,
    CupertinoIcons.Outlined.DeleteRight,
    CupertinoIcons.Outlined.Desktopcomputer,
    CupertinoIcons.Outlined.Dice,
    CupertinoIcons.Outlined.Display,
    CupertinoIcons.Outlined.Divide,
    CupertinoIcons.Outlined.Doc,
    CupertinoIcons.Outlined.DocBadgeArrowUp,
    CupertinoIcons.Outlined.DocBadgePlus,
    CupertinoIcons.Outlined.DocOnDoc,
    CupertinoIcons.Outlined.DocPlaintext,
    CupertinoIcons.Outlined.DocText,
    CupertinoIcons.Outlined.DocTextMagnifyingglass,
    CupertinoIcons.Outlined.Dollarsign,
    CupertinoIcons.Outlined.DollarsignArrowCirclepath,
    CupertinoIcons.Outlined.DoorLeftHandClosed,
    CupertinoIcons.Outlined.DoorLeftHandOpen,
    CupertinoIcons.Outlined.DotRadiowavesLeftAndRight,
    CupertinoIcons.Outlined.DotRadiowavesUpForward,
    CupertinoIcons.Outlined.Drop,
    CupertinoIcons.Outlined.Ear,
    CupertinoIcons.Outlined.Earpods,
    CupertinoIcons.Outlined.Ellipsis,
    CupertinoIcons.Outlined.EllipsisBubble,
    CupertinoIcons.Outlined.EllipsisCircle,
    CupertinoIcons.Outlined.EllipsisCurlybraces,
    CupertinoIcons.Outlined.EllipsisMessage,
    CupertinoIcons.Outlined.Envelope,
    CupertinoIcons.Outlined.EnvelopeBadge,
    CupertinoIcons.Outlined.EnvelopeCircle,
    CupertinoIcons.Outlined.EnvelopeOpen,
    CupertinoIcons.Outlined.Eraser,
    CupertinoIcons.Outlined.Eurosign,
    CupertinoIcons.Outlined.Exclamationmark,
    CupertinoIcons.Outlined.Exclamationmark2,
    CupertinoIcons.Outlined.Exclamationmark3,
    CupertinoIcons.Outlined.ExclamationmarkArrowTriangle2Circlepath,
    CupertinoIcons.Outlined.ExclamationmarkCircle,
    CupertinoIcons.Outlined.ExclamationmarkIcloud,
    CupertinoIcons.Outlined.ExclamationmarkSquare,
    CupertinoIcons.Outlined.ExclamationmarkTriangle,
    CupertinoIcons.Outlined.Externaldrive,
    CupertinoIcons.Outlined.Eye,
    CupertinoIcons.Outlined.EyeSlash,
    CupertinoIcons.Outlined.Eyebrow,
    CupertinoIcons.Outlined.Eyedropper,
    CupertinoIcons.Outlined.Eyeglasses,
    CupertinoIcons.Outlined.Eyes,
    CupertinoIcons.Outlined.FaceSmiling,
    CupertinoIcons.Outlined.FaceSmilingInverse,
    CupertinoIcons.Outlined.Faceid,
    CupertinoIcons.Outlined.Facemask,
    CupertinoIcons.Outlined.Fanblades,
    CupertinoIcons.Outlined.FanbladesSlash,
    CupertinoIcons.Outlined.Fibrechannel,
    CupertinoIcons.Outlined.FigureStand,
    CupertinoIcons.Outlined.FigureWalk,
    CupertinoIcons.Outlined.Film,
    CupertinoIcons.Outlined.Flag,
    CupertinoIcons.Outlined.Flag2Crossed,
    CupertinoIcons.Outlined.FlagCheckered2Crossed,
    CupertinoIcons.Outlined.FlagSlash,
    CupertinoIcons.Outlined.Flame,
    CupertinoIcons.Outlined.Flowchart,
    CupertinoIcons.Outlined.Folder,
    CupertinoIcons.Outlined.FolderBadgePlus,
    CupertinoIcons.Outlined.Football,
    CupertinoIcons.Outlined.ForkKnife,
    CupertinoIcons.Outlined.ForkKnifeCircle,
    CupertinoIcons.Outlined.Forward,
    CupertinoIcons.Outlined.ForwardEnd,
    CupertinoIcons.Outlined.Francsign,
    CupertinoIcons.Outlined.Fuelpump,
    CupertinoIcons.Outlined.Gamecontroller,
    CupertinoIcons.Outlined.Gear,
    CupertinoIcons.Outlined.Gearshape,
    CupertinoIcons.Outlined.Gearshape2,
    CupertinoIcons.Outlined.Gift,
    CupertinoIcons.Outlined.Giftcard,
    CupertinoIcons.Outlined.GlobeDesk,
    CupertinoIcons.Outlined.Gobackward,
    CupertinoIcons.Outlined.Goforward,
    CupertinoIcons.Outlined.Graduationcap,
    CupertinoIcons.Outlined.Grid,
    CupertinoIcons.Outlined.Hammer,
    CupertinoIcons.Outlined.HandDraw,
    CupertinoIcons.Outlined.HandPointUp,
    CupertinoIcons.Outlined.HandPointUpLeft,
    CupertinoIcons.Outlined.HandRaised,
    CupertinoIcons.Outlined.HandRaisedSlash,
    CupertinoIcons.Outlined.HandTap,
    CupertinoIcons.Outlined.HandThumbsdown,
    CupertinoIcons.Outlined.HandThumbsup,
    CupertinoIcons.Outlined.HandWave,
    CupertinoIcons.Outlined.HandsSparkles,
    CupertinoIcons.Outlined.Headphones,
    CupertinoIcons.Outlined.HeadphonesCircle,
    CupertinoIcons.Outlined.Heart,
    CupertinoIcons.Outlined.HeartCircle,
    CupertinoIcons.Outlined.HeartSlash,
    CupertinoIcons.Outlined.HeartTextSquare,
    CupertinoIcons.Outlined.Hifispeaker,
    CupertinoIcons.Outlined.Highlighter,
    CupertinoIcons.Outlined.Homekit,
    CupertinoIcons.Outlined.Homepod,
    CupertinoIcons.Outlined.Homepodmini,
    CupertinoIcons.Outlined.Hourglass,
    CupertinoIcons.Outlined.House,
    CupertinoIcons.Outlined.Hryvniasign,
    CupertinoIcons.Outlined.Icloud,
    CupertinoIcons.Outlined.IcloudAndArrowDown,
    CupertinoIcons.Outlined.IcloudAndArrowUp,
    CupertinoIcons.Outlined.Infinity,
    CupertinoIcons.Outlined.Info,
    CupertinoIcons.Outlined.InfoBubble,
    CupertinoIcons.Outlined.InfoCircle,
    CupertinoIcons.Outlined.InfoSquare,
    CupertinoIcons.Outlined.Ipad,
    CupertinoIcons.Outlined.IpadAndIphone,
    CupertinoIcons.Outlined.IpadHomebutton,
    CupertinoIcons.Outlined.Iphone,
    CupertinoIcons.Outlined.IphoneBadgePlay,
    CupertinoIcons.Outlined.IphoneHomebutton,
    CupertinoIcons.Outlined.IphoneHomebuttonRadiowavesLeftAndRight,
    CupertinoIcons.Outlined.IphoneRadiowavesLeftAndRight,
    CupertinoIcons.Outlined.Key,
    CupertinoIcons.Outlined.KeyIcloud,
    CupertinoIcons.Outlined.Keyboard,
    CupertinoIcons.Outlined.Lanyardcard,
    CupertinoIcons.Outlined.Laptopcomputer,
    CupertinoIcons.Outlined.LaptopcomputerAndIpad,
    CupertinoIcons.Outlined.LaptopcomputerAndIphone,
    CupertinoIcons.Outlined.Leaf,
    CupertinoIcons.Outlined.Level,
    CupertinoIcons.Outlined.Lifepreserver,
    CupertinoIcons.Outlined.LightBeaconMax,
    CupertinoIcons.Outlined.LightMax,
    CupertinoIcons.Outlined.LightMin,
    CupertinoIcons.Outlined.Lightbulb,
    CupertinoIcons.Outlined.LightbulbSlash,
    CupertinoIcons.Outlined.Link,
    CupertinoIcons.Outlined.LinkBadgePlus,
    CupertinoIcons.Outlined.LinkCircle,
    CupertinoIcons.Outlined.Lirasign,
    CupertinoIcons.Outlined.ListBullet,
    CupertinoIcons.Outlined.ListBulletCircle,
    CupertinoIcons.Outlined.ListBulletClipboard,
    CupertinoIcons.Outlined.ListBulletIndent,
    CupertinoIcons.Outlined.ListClipboard,
    CupertinoIcons.Outlined.ListNumber,
    CupertinoIcons.Outlined.Livephoto,
    CupertinoIcons.Outlined.Location,
    CupertinoIcons.Outlined.Lock,
    CupertinoIcons.Outlined.LockCircle,
    CupertinoIcons.Outlined.LockOpen,
    CupertinoIcons.Outlined.LockSlash,
    CupertinoIcons.Outlined.Macwindow,
    CupertinoIcons.Outlined.MacwindowBadgePlus,
    CupertinoIcons.Outlined.Magazine,
    CupertinoIcons.Outlined.Mail,
    CupertinoIcons.Outlined.MailStack,
    CupertinoIcons.Outlined.Map,
    CupertinoIcons.Outlined.Mappin,
    CupertinoIcons.Outlined.MappinAndEllipse,
    CupertinoIcons.Outlined.MappinSlash,
    CupertinoIcons.Outlined.Medal,
    CupertinoIcons.Outlined.Megaphone,
    CupertinoIcons.Outlined.Memories,
    CupertinoIcons.Outlined.MenubarRectangle,
    CupertinoIcons.Outlined.Menucard,
    CupertinoIcons.Outlined.Message,
    CupertinoIcons.Outlined.MessageBadge,
    CupertinoIcons.Outlined.Mic,
    CupertinoIcons.Outlined.MicSlash,
    CupertinoIcons.Outlined.Minus,
    CupertinoIcons.Outlined.MinusCircle,
    CupertinoIcons.Outlined.MinusMagnifyingglass,
    CupertinoIcons.Outlined.Moon,
    CupertinoIcons.Outlined.MoonStars,
    CupertinoIcons.Outlined.Mount,
    CupertinoIcons.Outlined.Multiply,
    CupertinoIcons.Outlined.MusicMic,
    CupertinoIcons.Outlined.MusicNote,
    CupertinoIcons.Outlined.MusicNoteList,
    CupertinoIcons.Outlined.MusicQuarternote3,
    CupertinoIcons.Outlined.Network,
    CupertinoIcons.Outlined.Newspaper,
    CupertinoIcons.Outlined.Nosign,
    CupertinoIcons.Outlined.NoteText,
    CupertinoIcons.Outlined.NoteTextBadgePlus,
    CupertinoIcons.Outlined.Number,
    CupertinoIcons.Outlined.Opticaldisc,
    CupertinoIcons.Outlined.Option,
    CupertinoIcons.Outlined.Paintbrush,
    CupertinoIcons.Outlined.PaintbrushPointed,
    CupertinoIcons.Outlined.Paintpalette,
    CupertinoIcons.Outlined.Paperclip,
    CupertinoIcons.Outlined.PaperclipBadgeEllipsis,
    CupertinoIcons.Outlined.PaperclipCircle,
    CupertinoIcons.Outlined.Paperplane,
    CupertinoIcons.Outlined.Paragraphsign,
    CupertinoIcons.Outlined.PartyPopper,
    CupertinoIcons.Outlined.Pause,
    CupertinoIcons.Outlined.PauseCircle,
    CupertinoIcons.Outlined.Pawprint,
    CupertinoIcons.Outlined.Pencil,
    CupertinoIcons.Outlined.PencilCircle,
    CupertinoIcons.Outlined.PencilTipCropCircle,
    CupertinoIcons.Outlined.Percent,
    CupertinoIcons.Outlined.Person,
    CupertinoIcons.Outlined.Person2,
    CupertinoIcons.Outlined.PersonAndBackgroundDotted,
    CupertinoIcons.Outlined.PersonCircle,
    CupertinoIcons.Outlined.PersonCropCircle,
    CupertinoIcons.Outlined.PersonCropCircleBadgeMinus,
    CupertinoIcons.Outlined.PersonCropCircleBadgePlus,
    CupertinoIcons.Outlined.PersonCropSquare,
    CupertinoIcons.Outlined.PersonIcloud,
    CupertinoIcons.Outlined.PersonTextRectangle,
    CupertinoIcons.Outlined.PersonWave2,
    CupertinoIcons.Outlined.Personalhotspot,
    CupertinoIcons.Outlined.Phone,
    CupertinoIcons.Outlined.PhoneAndWaveform,
    CupertinoIcons.Outlined.PhoneArrowDownLeft,
    CupertinoIcons.Outlined.PhoneArrowUpRight,
    CupertinoIcons.Outlined.PhoneBadgePlus,
    CupertinoIcons.Outlined.PhoneCircle,
    CupertinoIcons.Outlined.PhoneConnection,
    CupertinoIcons.Outlined.Photo,
    CupertinoIcons.Outlined.PhotoStack,
    CupertinoIcons.Outlined.PhotoTv,
    CupertinoIcons.Outlined.Pill,
    CupertinoIcons.Outlined.Pin,
    CupertinoIcons.Outlined.PinCircle,
    CupertinoIcons.Outlined.PinSlash,
    CupertinoIcons.Outlined.Pip,
    CupertinoIcons.Outlined.PipEnter,
    CupertinoIcons.Outlined.PipExit,
    CupertinoIcons.Outlined.Play,
    CupertinoIcons.Outlined.PlayCircle,
    CupertinoIcons.Outlined.PlayDisplay,
    CupertinoIcons.Outlined.Plus,
    CupertinoIcons.Outlined.PlusApp,
    CupertinoIcons.Outlined.PlusBubble,
    CupertinoIcons.Outlined.PlusCircle,
    CupertinoIcons.Outlined.PlusMagnifyingglass,
    CupertinoIcons.Outlined.PlusMessage,
    CupertinoIcons.Outlined.PlusSquare,
    CupertinoIcons.Outlined.PlusViewfinder,
    CupertinoIcons.Outlined.Popcorn,
    CupertinoIcons.Outlined.Power,
    CupertinoIcons.Outlined.PowerCircle,
    CupertinoIcons.Outlined.Printer,
    CupertinoIcons.Outlined.Puzzlepiece,
    CupertinoIcons.Outlined.PuzzlepieceExtension,
    CupertinoIcons.Outlined.Qrcode,
    CupertinoIcons.Outlined.QrcodeViewfinder,
    CupertinoIcons.Outlined.Questionmark,
    CupertinoIcons.Outlined.QuestionmarkApp,
    CupertinoIcons.Outlined.QuestionmarkCircle,
    CupertinoIcons.Outlined.QuestionmarkFolder,
    CupertinoIcons.Outlined.QuestionmarkSquare,
    CupertinoIcons.Outlined.QuoteClosing,
    CupertinoIcons.Outlined.QuoteOpening,
    CupertinoIcons.Outlined.Rays,
    CupertinoIcons.Outlined.RecordCircle,
    CupertinoIcons.Outlined.Recordingtape,
    CupertinoIcons.Outlined.RectangleArrowtriangle2Outward,
    CupertinoIcons.Outlined.RectangleConnectedToLineBelow,
    CupertinoIcons.Outlined.RectanglePortraitAndArrowForward,
    CupertinoIcons.Outlined.RectanglePortraitArrowtriangle2Outward,
    CupertinoIcons.Outlined.RectangleStack,
    CupertinoIcons.Outlined.Repeat,
    CupertinoIcons.Outlined.Rosette,
    CupertinoIcons.Outlined.Rotate3d,
    CupertinoIcons.Outlined.RotateLeft,
    CupertinoIcons.Outlined.RotateRight,
    CupertinoIcons.Outlined.Rublesign,
    CupertinoIcons.Outlined.Ruler,
    CupertinoIcons.Outlined.Safari,
    CupertinoIcons.Outlined.Scalemass,
    CupertinoIcons.Outlined.Scissors,
    CupertinoIcons.Outlined.Scope,
    CupertinoIcons.Outlined.Scribble,
    CupertinoIcons.Outlined.ScribbleVariable,
    CupertinoIcons.Outlined.Scroll,
    CupertinoIcons.Outlined.ServerRack,
    CupertinoIcons.Outlined.Shareplay,
    CupertinoIcons.Outlined.ShareplaySlash,
    CupertinoIcons.Outlined.ShazamLogo,
    CupertinoIcons.Outlined.Shield,
    CupertinoIcons.Outlined.ShieldSlash,
    CupertinoIcons.Outlined.Shippingbox,
    CupertinoIcons.Outlined.Shuffle,
    CupertinoIcons.Outlined.SidebarLeft,
    CupertinoIcons.Outlined.SidebarRight,
    CupertinoIcons.Outlined.Simcard,
    CupertinoIcons.Outlined.Skew,
    CupertinoIcons.Outlined.SliderHorizontal3,
    CupertinoIcons.Outlined.SliderVertical3,
    CupertinoIcons.Outlined.Snowflake,
    CupertinoIcons.Outlined.Soccerball,
    CupertinoIcons.Outlined.Space,
    CupertinoIcons.Outlined.Sparkle,
    CupertinoIcons.Outlined.Sparkles,
    CupertinoIcons.Outlined.Speaker,
    CupertinoIcons.Outlined.SpeakerMinus,
    CupertinoIcons.Outlined.SpeakerPlus,
    CupertinoIcons.Outlined.SpeakerSlash,
    CupertinoIcons.Outlined.SpeakerWave2,
    CupertinoIcons.Outlined.Speedometer,
    CupertinoIcons.Outlined.Square3Layers3dDownLeft,
    CupertinoIcons.Outlined.Square3Layers3dDownRight,
    CupertinoIcons.Outlined.SquareAndArrowUp,
    CupertinoIcons.Outlined.SquareAndPencil,
    CupertinoIcons.Outlined.SquareOnSquare,
    CupertinoIcons.Outlined.SquareSplit1x2,
    CupertinoIcons.Outlined.SquareSplit2x1,
    CupertinoIcons.Outlined.SquareStack,
    CupertinoIcons.Outlined.SquareStack3dUp,
    CupertinoIcons.Outlined.Star,
    CupertinoIcons.Outlined.StarSlash,
    CupertinoIcons.Outlined.Staroflife,
    CupertinoIcons.Outlined.Sterlingsign,
    CupertinoIcons.Outlined.Stethoscope,
    CupertinoIcons.Outlined.Stop,
    CupertinoIcons.Outlined.StopCircle,
    CupertinoIcons.Outlined.Suitcase,
    CupertinoIcons.Outlined.Sum,
    CupertinoIcons.Outlined.SunMax,
    CupertinoIcons.Outlined.Swift,
    CupertinoIcons.Outlined.Tag,
    CupertinoIcons.Outlined.Target,
    CupertinoIcons.Outlined.TennisRacket,
    CupertinoIcons.Outlined.Terminal,
    CupertinoIcons.Outlined.TextBubble,
    CupertinoIcons.Outlined.TextMagnifyingglass,
    CupertinoIcons.Outlined.Theatermasks,
    CupertinoIcons.Outlined.Timer,
    CupertinoIcons.Outlined.Touchid,
    CupertinoIcons.Outlined.Trash,
    CupertinoIcons.Outlined.TrashSlash,
    CupertinoIcons.Outlined.TrayAndArrowDown,
    CupertinoIcons.Outlined.TrayAndArrowUp,
    CupertinoIcons.Outlined.Trophy,
    CupertinoIcons.Outlined.Tshirt,
    CupertinoIcons.Outlined.Tv,
    CupertinoIcons.Outlined.Umbrella,
    CupertinoIcons.Outlined.Video,
    CupertinoIcons.Outlined.VideoCircle,
    CupertinoIcons.Outlined.VideoSlash,
    CupertinoIcons.Outlined.Volleyball,
    CupertinoIcons.Outlined.WalletPass,
    CupertinoIcons.Outlined.WandAndStars,
    CupertinoIcons.Outlined.WandAndStarsInverse,
    CupertinoIcons.Outlined.Waveform,
    CupertinoIcons.Outlined.WaveformAndMagnifyingglass,
    CupertinoIcons.Outlined.WaveformAndMic,
    CupertinoIcons.Outlined.WaveformPathEcg,
    CupertinoIcons.Outlined.WebCamera,
    CupertinoIcons.Outlined.Wifi,
    CupertinoIcons.Outlined.WifiExclamationmark,
    CupertinoIcons.Outlined.WifiRouter,
    CupertinoIcons.Outlined.WifiSlash,
    CupertinoIcons.Outlined.Wind,
    CupertinoIcons.Outlined.Wineglass,
    CupertinoIcons.Outlined.WrenchAndScrewdriver,
    CupertinoIcons.Outlined.Xmark,
    CupertinoIcons.Outlined.XmarkApp,
    CupertinoIcons.Outlined.XmarkBin,
    CupertinoIcons.Outlined.XmarkCircle,
    CupertinoIcons.Outlined.XmarkIcloud,
    CupertinoIcons.Outlined.XmarkSeal,
    CupertinoIcons.Outlined.XmarkShield,
    CupertinoIcons.Outlined.Yensign,
    CupertinoIcons.Outlined.Zzz,
    CupertinoIcons.Outlined._4kTv,
)

private val Filled = listOf(
            CupertinoIcons.Filled.Airtag,
            CupertinoIcons.Filled.Alarm,
            CupertinoIcons.Filled.Appletv,
            CupertinoIcons.Filled.Archivebox,
            CupertinoIcons.Filled.ArrowClockwiseCircle,
            CupertinoIcons.Filled.ArrowCounterclockwiseCircle,
            CupertinoIcons.Filled.ArrowCounterclockwiseIcloud,
            CupertinoIcons.Filled.ArrowDownCircle,
            CupertinoIcons.Filled.ArrowDownDoc,
            CupertinoIcons.Filled.ArrowTriangle2CirclepathCamera,
            CupertinoIcons.Filled.ArrowTriangle2CirclepathCircle,
            CupertinoIcons.Filled.ArrowTurnUpForwardIphone,
            CupertinoIcons.Filled.ArrowUpDoc,
            CupertinoIcons.Filled.ArrowshapeTurnUpLeft,
            CupertinoIcons.Filled.ArrowshapeTurnUpLeft2,
            CupertinoIcons.Filled.Backward,
            CupertinoIcons.Filled.BackwardEnd,
            CupertinoIcons.Filled.Bag,
            CupertinoIcons.Filled.BagBadgeMinus,
            CupertinoIcons.Filled.BagBadgePlus,
            CupertinoIcons.Filled.Balloon,
            CupertinoIcons.Filled.Bandage,
            CupertinoIcons.Filled.Banknote,
            CupertinoIcons.Filled.Baseball,
            CupertinoIcons.Filled.Basket,
            CupertinoIcons.Filled.Basketball,
            CupertinoIcons.Filled.BedDouble,
            CupertinoIcons.Filled.Bell,
            CupertinoIcons.Filled.BellAndWavesLeftAndRight,
            CupertinoIcons.Filled.BellBadge,
            CupertinoIcons.Filled.BellCircle,
            CupertinoIcons.Filled.BellSlash,
            CupertinoIcons.Filled.Binoculars,
            CupertinoIcons.Filled.BirthdayCake,
            CupertinoIcons.Filled.Bolt,
            CupertinoIcons.Filled.BoltHorizontal,
            CupertinoIcons.Filled.BoltSlash,
            CupertinoIcons.Filled.Book,
            CupertinoIcons.Filled.BookCircle,
            CupertinoIcons.Filled.BookClosed,
            CupertinoIcons.Filled.Bookmark,
            CupertinoIcons.Filled.BookmarkSlash,
            CupertinoIcons.Filled.Briefcase,
            CupertinoIcons.Filled.BubbleLeft,
            CupertinoIcons.Filled.BubbleRight,
            CupertinoIcons.Filled.Building,
            CupertinoIcons.Filled.Building2,
            CupertinoIcons.Filled.Burst,
            CupertinoIcons.Filled.Camera,
            CupertinoIcons.Filled.CameraCircle,
            CupertinoIcons.Filled.Capslock,
            CupertinoIcons.Filled.Car,
            CupertinoIcons.Filled.Cart,
            CupertinoIcons.Filled.CartBadgeMinus,
            CupertinoIcons.Filled.CartBadgePlus,
            CupertinoIcons.Filled.Case,
            CupertinoIcons.Filled.ChartBar,
            CupertinoIcons.Filled.CheckmarkCircle,
            CupertinoIcons.Filled.CheckmarkIcloud,
            CupertinoIcons.Filled.CheckmarkMessage,
            CupertinoIcons.Filled.CheckmarkSeal,
            CupertinoIcons.Filled.CheckmarkShield,
            CupertinoIcons.Filled.CheckmarkSquare,
            CupertinoIcons.Filled.CircleLefthalfed,
            CupertinoIcons.Filled.CircleRighthalfed,
            CupertinoIcons.Filled.Clear,
            CupertinoIcons.Filled.Clipboard,
            CupertinoIcons.Filled.Clock,
            CupertinoIcons.Filled.Cloud,
            CupertinoIcons.Filled.Cone,
            CupertinoIcons.Filled.Cpu,
            CupertinoIcons.Filled.Creditcard,
            CupertinoIcons.Filled.Cross,
            CupertinoIcons.Filled.CrossCircle,
            CupertinoIcons.Filled.CrossVial,
            CupertinoIcons.Filled.Crown,
            CupertinoIcons.Filled.Cube,
            CupertinoIcons.Filled.CupAndSaucer,
            CupertinoIcons.Filled.DeleteLeft,
            CupertinoIcons.Filled.DeleteRight,
            CupertinoIcons.Filled.Dice,
            CupertinoIcons.Filled.Doc,
            CupertinoIcons.Filled.DocBadgeArrowUp,
            CupertinoIcons.Filled.DocBadgePlus,
            CupertinoIcons.Filled.DocOnDoc,
            CupertinoIcons.Filled.DocPlaintext,
            CupertinoIcons.Filled.DocText,
            CupertinoIcons.Filled.Drop,
            CupertinoIcons.Filled.Ear,
            CupertinoIcons.Filled.EllipsisBubble,
            CupertinoIcons.Filled.EllipsisCircle,
            CupertinoIcons.Filled.EllipsisMessage,
            CupertinoIcons.Filled.Envelope,
            CupertinoIcons.Filled.EnvelopeBadge,
            CupertinoIcons.Filled.EnvelopeCircle,
            CupertinoIcons.Filled.EnvelopeOpen,
            CupertinoIcons.Filled.Eraser,
            CupertinoIcons.Filled.ExclamationmarkCircle,
            CupertinoIcons.Filled.ExclamationmarkIcloud,
            CupertinoIcons.Filled.ExclamationmarkSquare,
            CupertinoIcons.Filled.ExclamationmarkTriangle,
            CupertinoIcons.Filled.Externaldrive,
            CupertinoIcons.Filled.Eye,
            CupertinoIcons.Filled.EyeSlash,
            CupertinoIcons.Filled.Facemask,
            CupertinoIcons.Filled.Fanblades,
            CupertinoIcons.Filled.FanbladesSlash,
            CupertinoIcons.Filled.Film,
            CupertinoIcons.Filled.Flag,
            CupertinoIcons.Filled.Flag2Crossed,
            CupertinoIcons.Filled.FlagSlash,
            CupertinoIcons.Filled.Flame,
            CupertinoIcons.Filled.Folder,
            CupertinoIcons.Filled.FolderBadgePlus,
            CupertinoIcons.Filled.Football,
            CupertinoIcons.Filled.ForkKnifeCircle,
            CupertinoIcons.Filled.Forward,
            CupertinoIcons.Filled.ForwardEnd,
            CupertinoIcons.Filled.Fuelpump,
            CupertinoIcons.Filled.Gamecontroller,
            CupertinoIcons.Filled.Gearshape,
            CupertinoIcons.Filled.Gearshape2,
            CupertinoIcons.Filled.Gift,
            CupertinoIcons.Filled.Giftcard,
            CupertinoIcons.Filled.GlobeDesk,
            CupertinoIcons.Filled.Graduationcap,
            CupertinoIcons.Filled.Hammer,
            CupertinoIcons.Filled.HandDraw,
            CupertinoIcons.Filled.HandPointUp,
            CupertinoIcons.Filled.HandPointUpLeft,
            CupertinoIcons.Filled.HandRaised,
            CupertinoIcons.Filled.HandRaisedSlash,
            CupertinoIcons.Filled.HandTap,
            CupertinoIcons.Filled.HandThumbsdown,
            CupertinoIcons.Filled.HandThumbsup,
            CupertinoIcons.Filled.HandWave,
            CupertinoIcons.Filled.HandsSparkles,
            CupertinoIcons.Filled.HeadphonesCircle,
            CupertinoIcons.Filled.Heart,
            CupertinoIcons.Filled.HeartCircle,
            CupertinoIcons.Filled.HeartSlash,
            CupertinoIcons.Filled.HeartTextSquare,
            CupertinoIcons.Filled.Hifispeaker,
            CupertinoIcons.Filled.Homepod,
            CupertinoIcons.Filled.Homepodmini,
            CupertinoIcons.Filled.House,
            CupertinoIcons.Filled.Icloud,
            CupertinoIcons.Filled.IcloudAndArrowDown,
            CupertinoIcons.Filled.IcloudAndArrowUp,
            CupertinoIcons.Filled.InfoBubble,
            CupertinoIcons.Filled.InfoCircle,
            CupertinoIcons.Filled.InfoSquare,
            CupertinoIcons.Filled.Key,
            CupertinoIcons.Filled.KeyIcloud,
            CupertinoIcons.Filled.Keyboard,
            CupertinoIcons.Filled.Lanyardcard,
            CupertinoIcons.Filled.Leaf,
            CupertinoIcons.Filled.Level,
            CupertinoIcons.Filled.Lifepreserver,
            CupertinoIcons.Filled.LightBeaconMax,
            CupertinoIcons.Filled.Lightbulb,
            CupertinoIcons.Filled.LightbulbSlash,
            CupertinoIcons.Filled.LinkCircle,
            CupertinoIcons.Filled.ListBulletCircle,
            CupertinoIcons.Filled.ListBulletClipboard,
            CupertinoIcons.Filled.ListClipboard,
            CupertinoIcons.Filled.Location,
            CupertinoIcons.Filled.Lock,
            CupertinoIcons.Filled.LockCircle,
            CupertinoIcons.Filled.LockOpen,
            CupertinoIcons.Filled.LockSlash,
            CupertinoIcons.Filled.Magazine,
            CupertinoIcons.Filled.Mail,
            CupertinoIcons.Filled.MailStack,
            CupertinoIcons.Filled.Map,
            CupertinoIcons.Filled.Medal,
            CupertinoIcons.Filled.Megaphone,
            CupertinoIcons.Filled.Menucard,
            CupertinoIcons.Filled.Message,
            CupertinoIcons.Filled.MessageBadgeed,
            CupertinoIcons.Filled.Mic,
            CupertinoIcons.Filled.MicSlash,
            CupertinoIcons.Filled.MinusCircle,
            CupertinoIcons.Filled.Moon,
            CupertinoIcons.Filled.MoonStars,
            CupertinoIcons.Filled.Mount,
            CupertinoIcons.Filled.Newspaper,
            CupertinoIcons.Filled.Opticaldisc,
            CupertinoIcons.Filled.Paintbrush,
            CupertinoIcons.Filled.PaintbrushPointed,
            CupertinoIcons.Filled.Paintpalette,
            CupertinoIcons.Filled.PaperclipCircle,
            CupertinoIcons.Filled.Paperplane,
            CupertinoIcons.Filled.PartyPopper,
            CupertinoIcons.Filled.Pause,
            CupertinoIcons.Filled.PauseCircle,
            CupertinoIcons.Filled.Pawprint,
            CupertinoIcons.Filled.PencilCircle,
            CupertinoIcons.Filled.Person,
            CupertinoIcons.Filled.Person2,
            CupertinoIcons.Filled.PersonCircle,
            CupertinoIcons.Filled.PersonCropCircle,
            CupertinoIcons.Filled.PersonCropCircleBadgeMinus,
            CupertinoIcons.Filled.PersonCropCircleBadgePlus,
            CupertinoIcons.Filled.PersonCropSquare,
            CupertinoIcons.Filled.PersonIcloud,
            CupertinoIcons.Filled.PersonTextRectangle,
            CupertinoIcons.Filled.PersonViewfinder,
            CupertinoIcons.Filled.PersonWave2,
            CupertinoIcons.Filled.Phone,
            CupertinoIcons.Filled.PhoneAndWaveform,
            CupertinoIcons.Filled.PhoneArrowDownLeft,
            CupertinoIcons.Filled.PhoneArrowUpRight,
            CupertinoIcons.Filled.PhoneBadgePlus,
            CupertinoIcons.Filled.PhoneCircle,
            CupertinoIcons.Filled.PhoneConnection,
            CupertinoIcons.Filled.Photo,
            CupertinoIcons.Filled.PhotoStack,
            CupertinoIcons.Filled.Pill,
            CupertinoIcons.Filled.Pin,
            CupertinoIcons.Filled.PinCircle,
            CupertinoIcons.Filled.PinSlash,
            CupertinoIcons.Filled.Pip,
            CupertinoIcons.Filled.Play,
            CupertinoIcons.Filled.PlayCircle,
            CupertinoIcons.Filled.PlusApp,
            CupertinoIcons.Filled.PlusBubble,
            CupertinoIcons.Filled.PlusCircle,
            CupertinoIcons.Filled.PlusMessage,
            CupertinoIcons.Filled.PlusSquare,
            CupertinoIcons.Filled.Popcorn,
            CupertinoIcons.Filled.PowerCircle,
            CupertinoIcons.Filled.Printer,
            CupertinoIcons.Filled.Puzzlepiece,
            CupertinoIcons.Filled.PuzzlepieceExtension,
            CupertinoIcons.Filled.QuestionmarkApp,
            CupertinoIcons.Filled.QuestionmarkCircle,
            CupertinoIcons.Filled.QuestionmarkFolder,
            CupertinoIcons.Filled.QuestionmarkSquare,
            CupertinoIcons.Filled.RecordCircle,
            CupertinoIcons.Filled.RectanglePortraitAndArrowForward,
            CupertinoIcons.Filled.RectangleStack,
            CupertinoIcons.Filled.RotateLeft,
            CupertinoIcons.Filled.RotateRight,
            CupertinoIcons.Filled.Ruler,
            CupertinoIcons.Filled.Safari,
            CupertinoIcons.Filled.Scalemass,
            CupertinoIcons.Filled.Scroll,
            CupertinoIcons.Filled.ShazamLogo,
            CupertinoIcons.Filled.Shield,
            CupertinoIcons.Filled.ShieldLefthalfed,
            CupertinoIcons.Filled.ShieldRighthalfed,
            CupertinoIcons.Filled.ShieldSlash,
            CupertinoIcons.Filled.Shippingbox,
            CupertinoIcons.Filled.Shoeprints,
            CupertinoIcons.Filled.Simcard,
            CupertinoIcons.Filled.SmallcircleedCircle,
            CupertinoIcons.Filled.Speaker,
            CupertinoIcons.Filled.SpeakerMinus,
            CupertinoIcons.Filled.SpeakerPlus,
            CupertinoIcons.Filled.SpeakerSlash,
            CupertinoIcons.Filled.SpeakerWave2,
            CupertinoIcons.Filled.SquareAndArrowUp,
            CupertinoIcons.Filled.SquareBottomthirdInseted,
            CupertinoIcons.Filled.SquareOnSquare,
            CupertinoIcons.Filled.SquareSplit1x2,
            CupertinoIcons.Filled.SquareSplit2x1,
            CupertinoIcons.Filled.SquareStack,
            CupertinoIcons.Filled.SquareStack3dUp,
            CupertinoIcons.Filled.SquareTopthirdInseted,
            CupertinoIcons.Filled.Star,
            CupertinoIcons.Filled.StarLeadinghalfed,
            CupertinoIcons.Filled.StarSlash,
            CupertinoIcons.Filled.Staroflife,
            CupertinoIcons.Filled.Stop,
            CupertinoIcons.Filled.StopCircle,
            CupertinoIcons.Filled.Suitcase,
            CupertinoIcons.Filled.SunMax,
            CupertinoIcons.Filled.Tag,
            CupertinoIcons.Filled.Terminal,
            CupertinoIcons.Filled.TextBubble,
            CupertinoIcons.Filled.Theatermasks,
            CupertinoIcons.Filled.Trash,
            CupertinoIcons.Filled.TrashSlash,
            CupertinoIcons.Filled.TrayAndArrowDown,
            CupertinoIcons.Filled.TrayAndArrowUp,
            CupertinoIcons.Filled.Trophy,
            CupertinoIcons.Filled.Tshirt,
            CupertinoIcons.Filled.Tv,
            CupertinoIcons.Filled.TvAndHifispeaker,
            CupertinoIcons.Filled.Umbrella,
            CupertinoIcons.Filled.Video,
            CupertinoIcons.Filled.VideoCircle,
            CupertinoIcons.Filled.VideoSlash,
            CupertinoIcons.Filled.Volleyball,
            CupertinoIcons.Filled.WalletPass,
            CupertinoIcons.Filled.WebCamera,
            CupertinoIcons.Filled.WifiRouter,
            CupertinoIcons.Filled.Wineglass,
            CupertinoIcons.Filled.XmarkApp,
            CupertinoIcons.Filled.XmarkBin,
            CupertinoIcons.Filled.XmarkCircle,
            CupertinoIcons.Filled.XmarkIcloud,
            CupertinoIcons.Filled.XmarkSeal,
            CupertinoIcons.Filled.XmarkShield,
            CupertinoIcons.Filled._4kTv,
)