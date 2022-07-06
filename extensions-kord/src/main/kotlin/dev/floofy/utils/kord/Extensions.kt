package dev.floofy.utils.kord

import dev.kord.common.Color
import dev.kord.common.entity.Permission
import dev.kord.common.entity.Snowflake
import dev.kord.core.event.Event
import dev.kord.core.event.channel.*
import dev.kord.core.event.channel.thread.*
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.event.gateway.ResumedEvent
import dev.kord.core.event.guild.*
import dev.kord.core.event.interaction.ApplicationCommandCreateEvent
import dev.kord.core.event.interaction.ApplicationCommandDeleteEvent
import dev.kord.core.event.interaction.ApplicationCommandUpdateEvent
import dev.kord.core.event.interaction.InteractionCreateEvent
import dev.kord.core.event.message.*
import dev.kord.core.event.role.RoleCreateEvent
import dev.kord.core.event.role.RoleDeleteEvent
import dev.kord.core.event.role.RoleUpdateEvent
import dev.kord.core.event.user.PresenceUpdateEvent
import dev.kord.core.event.user.UserUpdateEvent
import dev.kord.core.event.user.VoiceStateUpdateEvent
import java.awt.Color as AwtColor

/**
 * Returns a [Snowflake] of this string, if it's compatible.
 */
fun String.toSnowflake(): Snowflake = Snowflake(this)

/**
 * Returns a [Snowflake] of this [Long].
 */
fun Long.toSnowflake(): Snowflake = Snowflake(this)

/**
 * Returns this [AwtColor] to a Kord [Color].
 */
fun AwtColor.toKordColor(): Color = Color(red, green, blue)

/**
 * Returns the name of this [Event] corresponding to the raw Discord
 * event key from the gateway.
 */
val Event.name: String
    get() = when (this) {
        is ResumedEvent -> "RESUMED"
        is ReadyEvent -> "READY"
        is ChannelCreateEvent -> "CHANNEL_CREATE"
        is ChannelUpdateEvent -> "CHANNEL_UPDATE"
        is ChannelDeleteEvent -> "CHANNEL_DELETE"
        is ChannelPinsUpdateEvent -> "CHANNEL_PINS_UPDATE"
        is TypingStartEvent -> "TYPING_START"
        is GuildCreateEvent -> "GUILD_CREATE"
        is GuildUpdateEvent -> "GUILD_UPDATE"
        is GuildDeleteEvent -> "GUILD_DELETE"
        is BanAddEvent -> "GUILD_BAN_ADD"
        is BanRemoveEvent -> "GUILD_BAN_REMOVE"
        is EmojisUpdateEvent -> "GUILD_EMOJIS_UPDATE"
        is IntegrationsUpdateEvent -> "GUILD_INTEGRATIONS_UPDATE"
        is MemberJoinEvent -> "GUILD_MEMBER_ADD"
        is MemberLeaveEvent -> "GUILD_MEMBER_REMOVE"
        is MemberUpdateEvent -> "GUILD_MEMBER_UPDATE"
        is RoleCreateEvent -> "GUILD_ROLE_CREATE"
        is RoleDeleteEvent -> "GUILD_ROLE_DELETE"
        is RoleUpdateEvent -> "GUILD_ROLE_UPDATE"
        is MembersChunkEvent -> "GUILD_MEMBERS_CHUNK"
        is InviteCreateEvent -> "INVITE_CREATE"
        is InviteDeleteEvent -> "INVITE_DELETE"
        is MessageCreateEvent -> "MESSAGE_CREATE"
        is MessageUpdateEvent -> "MESSAGE_UPDATE"
        is MessageDeleteEvent -> "MESSAGE_DELETE"
        is MessageBulkDeleteEvent -> "MESSAGE_DELETE_BULK"
        is ReactionAddEvent -> "MESSAGE_REACTION_ADD"
        is ReactionRemoveEvent -> "MESSAGE_REACTION_REMOVE"
        is ReactionRemoveEmojiEvent -> "MESSAGE_REACTION_REMOVE_EMOJI"
        is PresenceUpdateEvent -> "PRESENCE_UPDATE"
        is UserUpdateEvent -> "USER_UPDATE"
        is VoiceStateUpdateEvent -> "VOICE_STATE_UPDATE"
        is VoiceServerUpdateEvent -> "VOICE_SERVER_UPDATE"
        is WebhookUpdateEvent -> "WEBHOOKS_UPDATE"
        is InteractionCreateEvent -> "INTERACTION_CREATE"
        is ApplicationCommandCreateEvent -> "APPLICATION_COMMAND_CREATE"
        is ApplicationCommandDeleteEvent -> "APPLICATION_COMMAND_DELETE"
        is ApplicationCommandUpdateEvent -> "APPLICATION_COMMAND_UPDATE"
        is ThreadChannelCreateEvent -> "THREAD_CREATE"
        is ThreadChannelDeleteEvent -> "THREAD_DELETE"
        is ThreadUpdateEvent -> "THREAD_UPDATE"
        is ThreadListSyncEvent -> "THREAD_LIST_SYNC"
        is ThreadMemberUpdateEvent -> "THREAD_MEMBER_UPDATE"
        is ThreadMembersUpdateEvent -> "THREAD_MEMBERS_UPDATE"
        is GuildScheduledEventCreateEvent -> "GUILD_SCHEDULED_EVENT_CREATE"
        is GuildScheduledEventDeleteEvent -> "GUILD_SCHEDULED_EVENT_DELETE"
        is GuildScheduledEventUpdateEvent -> "GUILD_SCHEDULED_EVENT_UPDATE"
        is GuildScheduledEventUserAddEvent -> "GUILD_SCHEDULED_EVENT_USER_ADD"
        is GuildScheduledEventUserRemoveEvent -> "GUILD_SCHEDULED_EVENT_USER_REMOVE"
        else -> "UNKNOWN (${this::class})"
    }

/**
 * Returns a prettified version of this [Permission]'s name.
 */
val Permission.name: String
    get() = when (this) {
        is Permission.CreateInstantInvite -> "Create Instant Invite"
        is Permission.KickMembers -> "Kick Members"
        is Permission.BanMembers -> "Ban Members"
        is Permission.Administrator -> "Administrator"
        is Permission.ManageChannels -> "Manage Channels"
        is Permission.AddReactions -> "Add Reactions"
        is Permission.ViewAuditLog -> "View Audit Log"
        is Permission.Stream -> "Stream in Voice Channels"
        is Permission.ViewChannel -> "Read Messages in Guild Channels"
        is Permission.SendMessages -> "Send Messages in Guild Channels"
        is Permission.SendTTSMessages -> "Send Text-to-Speech Messages in Guild Channels"
        is Permission.EmbedLinks -> "Embed Links"
        is Permission.AttachFiles -> "Attach Files to Messages"
        is Permission.ReadMessageHistory -> "Read Message History in Guild Channels"
        is Permission.MentionEveryone -> "Mention Everyone"
        is Permission.UseExternalEmojis -> "Use External Emojis in Messages"
        is Permission.ViewGuildInsights -> "View Guild Insights"
        is Permission.Connect -> "Connect in Voice Channels"
        is Permission.Speak -> "Speak in Voice Channels"
        is Permission.MuteMembers -> "Mute Members in Voice Channels"
        is Permission.DeafenMembers -> "Deafen Members in Voice Channels"
        is Permission.MoveMembers -> "Move Members in Voice Channels"
        is Permission.UseVAD -> "Use VAD"
        is Permission.PrioritySpeaker -> "Priority Speaker"
        is Permission.ChangeNickname -> "Change Nickname"
        is Permission.ManageNicknames -> "Manage Member Nicknames"
        is Permission.ManageRoles -> "Manage Guild Roles"
        is Permission.ManageWebhooks -> "Manage Guild Webhooks"
        is Permission.ManageEmojisAndStickers -> "Manage Guild Emojis and Stickers"
        is Permission.ManageThreads -> "Manage Channel Threads"
        is Permission.CreatePrivateThreads -> "Create Private Threads"
        is Permission.CreatePublicThreads -> "Create Public Threads"
        is Permission.SendMessagesInThreads -> "Send Messages in Threads"
        is Permission.ManageGuild -> "Manage Guild"
        is Permission.ManageMessages -> "Manage Messages"
        is Permission.UseApplicationCommands -> "Use /commands in Guild Channels"
        is Permission.RequestToSpeak -> "Request To Speak"
        is Permission.ManageEvents -> "Manage Guild Events"
        is Permission.ModerateMembers -> "Moderate Guild Members"
        is Permission.All -> "All"
        is Permission.UseEmbeddedActivities -> "Use Embedded Activities"
        is Permission.UseExternalStickers -> "Use External Stickers"
        is Permission.Unknown -> "Unknown"
    }
